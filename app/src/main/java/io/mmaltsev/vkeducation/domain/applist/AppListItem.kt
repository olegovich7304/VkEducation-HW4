package io.mmaltsev.vkeducation.domain.applist

/**
 * Доменная модель приложения в списке.
 * Не зависит ни от Android, ни от Compose: цвет хранится числом ARGB.
 */
data class AppListItem(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val iconLetter: String,
    val colorArgb: Long,
)