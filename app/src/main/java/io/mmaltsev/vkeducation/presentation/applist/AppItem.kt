package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.ui.graphics.Color

/** UI-модель приложения: используется карточками (AppCard). */
data class AppItem(
    val name: String,
    val description: String,
    val category: String,
    val icon: String,
    val color: Color,
    val iconUrl: String? = null,
)

/** 9 приложений для блока «Витрина»: 3 страницы по 3 приложения. */
val showcaseApps = listOf(
    AppItem("Notion", "Заметки и базы знаний", "Работа", "N", Color(0xFF191919)),
    AppItem("WhatsApp", "Мессенджер и видеозвонки", "Общение", "W", Color(0xFF25D366)),
    AppItem("Netflix", "Фильмы и сериалы", "Развлечения", "N", Color(0xFFE50914)),
    AppItem("Discord", "Голосовые чаты для сообществ", "Общение", "D", Color(0xFF5865F2)),
    AppItem("Zoom", "Видеоконференции", "Работа", "Z", Color(0xFF2D8CFF)),
    AppItem("Twitch", "Стримы и киберспорт", "Развлечения", "T", Color(0xFF9146FF)),
    AppItem("Chrome", "Быстрый браузер", "Утилиты", "C", Color(0xFFFBBC05)),
    AppItem("Dropbox", "Облачное хранилище файлов", "Работа", "D", Color(0xFF0061FF)),
    AppItem("Pinterest", "Идеи и вдохновение", "Фото", "P", Color(0xFFE60023)),
)