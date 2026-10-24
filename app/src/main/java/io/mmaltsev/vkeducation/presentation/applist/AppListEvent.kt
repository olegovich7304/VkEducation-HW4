package io.mmaltsev.vkeducation.presentation.applist

sealed interface AppListEvent {
    data object ToolbarClicked : AppListEvent
}