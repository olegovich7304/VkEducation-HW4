package io.mmaltsev.vkeducation.presentation.applist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.mmaltsev.vkeducation.domain.applist.GetAppListUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val getAppListUseCase: GetAppListUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state = _state.asStateFlow()

    // Channel: каждое событие доставляется один раз и не повторяется после поворота экрана
    private val _events = Channel<AppListEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        loadApps()
    }

    fun onToolbarClick() {
        viewModelScope.launch {
            _events.send(AppListEvent.ToolbarClicked)
        }
    }

    private fun loadApps() {
        viewModelScope.launch {
            Log.d(TAG, "loadApps() called")
            _state.value = AppListState.Loading
            val apps = getAppListUseCase().map { it.toUi() }
            _state.value = AppListState.Content(apps)
        }
    }

    private companion object {
        const val TAG = "AppListViewModel"
    }
}