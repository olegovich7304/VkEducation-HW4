package io.mmaltsev.vkeducation.data.applist

import io.mmaltsev.vkeducation.domain.applist.AppListItem

class AppListMapper {

    fun toDomain(dto: AppListItemDto): AppListItem = AppListItem(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        category = dto.category,
        iconLetter = dto.icon,
        colorArgb = parseColor(dto.color),
    )

    // "#FF0033" -> 0xFFFF0033 (добавляем полную непрозрачность)
    private fun parseColor(hex: String): Long =
        hex.removePrefix("#").toLong(16) or 0xFF000000L
}