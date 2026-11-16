package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.runtime.Immutable

@Immutable
sealed interface AppListState {
    data object Loading : AppListState
    data object Error : AppListState
    data class Content(val apps: List<AppItem>) : AppListState
}