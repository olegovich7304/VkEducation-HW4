package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.ui.graphics.Color
import io.mmaltsev.vkeducation.domain.applist.AppListItem

// Domain -> UI-модель (здесь уже можно использовать Compose Color)
fun AppListItem.toUi(): AppItem = AppItem(
    name = name,
    description = description,
    category = category,
    icon = iconLetter,
    color = Color(colorArgb),
)