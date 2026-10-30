package io.mmaltsev.vkeducation.data.applist

data class AppListItemDto(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val icon: String,
    val color: String,
)