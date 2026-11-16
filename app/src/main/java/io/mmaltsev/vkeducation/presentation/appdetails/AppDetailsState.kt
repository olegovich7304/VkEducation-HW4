package io.mmaltsev.vkeducation.presentation.appdetails

import androidx.compose.runtime.Immutable
import io.mmaltsev.vkeducation.domain.appdetails.AppDetails
import io.mmaltsev.vkeducation.domain.appdetails.SimilarApp

sealed interface InstallState {
    data object NotInstalled : InstallState
    data class Installing(val progress: Int) : InstallState // 0..100
    data object Installed : InstallState
}

@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: AppDetails,
        val similarApps: List<SimilarApp>,
        val descriptionCollapsed: Boolean,
        val installState: InstallState = InstallState.NotInstalled,
    ) : AppDetailsState
}