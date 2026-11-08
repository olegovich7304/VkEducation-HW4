package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.ui.graphics.Color
import io.mmaltsev.vkeducation.domain.applist.AppListItem

fun AppListItem.toUi(): AppItem = AppItem(
    name = name,
    description = description,
    category = category,
    icon = name.take(1).uppercase(),
    color = Color(0xFF6750A4),
    iconUrl = iconUrl,
)