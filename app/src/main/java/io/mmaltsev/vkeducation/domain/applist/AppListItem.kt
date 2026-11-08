package io.mmaltsev.vkeducation.domain.applist

data class AppListItem(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val iconUrl: String?,
)