package io.mmaltsev.vkeducation.presentation.applist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.mmaltsev.vkeducation.domain.applist.GetAppListUseCase
import io.mmaltsev.vkeducation.domain.applist.RatingsRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.system.measureTimeMillis

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val getAppListUseCase: GetAppListUseCase,
    private val ratingsRepository: RatingsRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppListEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    private var loadJob: Job? = null

    init {
        loadApps()
    }

    fun onToolbarClick() {
        viewModelScope.launch {
            _events.send(AppListEvent.ToolbarClicked)
        }
    }

    fun loadApps() {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            Log.d(TAG, "loadApps() called")
            _state.value = AppListState.Loading
            val apps = try {
                getAppListUseCase().map { it.toUi() }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load catalog", e)
                _state.value = AppListState.Error
                return@launch
            }
            _state.value = AppListState.Content(apps)
            loadRatings(apps.map { it.id })
        }
    }

    private suspend fun loadRatings(ids: List<String>) {
        try {
            // 1) Параллельно: рейтинги приходят примерно через 1.5 с и сразу показываются
            var parallel: Map<String, Float> = emptyMap()
            val parallelMs = measureTimeMillis {
                parallel = ratingsRepository.loadRatingsInParallel(ids)
            }
            Log.d(TAG, "Ratings in PARALLEL: $parallelMs ms for ${ids.size} apps")
            showRatings(parallel)

            // 2) Последовательно: нужно только для замера времени (идёт долго, ~N * 1.5 с)
            val sequentialMs = measureTimeMillis {
                ratingsRepository.loadRatingsSequentially(ids)
            }
            Log.d(TAG, "Ratings SEQUENTIALLY: $sequentialMs ms for ${ids.size} apps")
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e(TAG, "Failed to load ratings", e)
        }
    }

    private fun showRatings(ratings: Map<String, Float>) {
        _state.update { current ->
            if (current is AppListState.Content) {
                current.copy(
                    apps = current.apps.map { it.copy(rating = ratings[it.id]) }
                )
            } else {
                current
            }
        }
    }

    private companion object {
        const val TAG = "AppListViewModel"
    }
}