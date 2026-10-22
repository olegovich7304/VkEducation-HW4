package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.ui.graphics.Color

data class AppItem(
    val name: String,
    val description: String,
    val category: String,
    val icon: String,
    val color: Color,
)

/** Приложения для экрана списка (из прошлого ДЗ). */
val catalogApps = listOf(
    AppItem("YouTube", "Просмотр видео и каналов", "Развлечения", "Y", Color(0xFFFF0033)),
    AppItem("Telegram", "Сообщения и звонки", "Общение", "T", Color(0xFF229ED9)),
    AppItem("Spotify", "Музыка и подкасты", "Музыка", "S", Color(0xFF1DB954)),
    AppItem("Google Maps", "Карты и навигация", "Путешествия", "M", Color(0xFF4285F4)),
    AppItem("Gmail", "Электронная почта", "Работа", "G", Color(0xFFEA4335)),
    AppItem("Duolingo", "Изучение иностранных языков", "Образование", "D", Color(0xFF58CC02)),
)

/** 9 приложений для блока «Витрина»: 3 страницы по 3 приложения. */
val showcaseApps = listOf(
    // Страница 1
    AppItem("Notion", "Заметки и базы знаний", "Работа", "N", Color(0xFF191919)),
    AppItem("WhatsApp", "Мессенджер и видеозвонки", "Общение", "W", Color(0xFF25D366)),
    AppItem("Netflix", "Фильмы и сериалы", "Развлечения", "N", Color(0xFFE50914)),
    // Страница 2
    AppItem("Discord", "Голосовые чаты для сообществ", "Общение", "D", Color(0xFF5865F2)),
    AppItem("Zoom", "Видеоконференции", "Работа", "Z", Color(0xFF2D8CFF)),
    AppItem("Twitch", "Стримы и киберспорт", "Развлечения", "T", Color(0xFF9146FF)),
    // Страница 3
    AppItem("Chrome", "Быстрый браузер", "Утилиты", "C", Color(0xFFFBBC05)),
    AppItem("Dropbox", "Облачное хранилище файлов", "Работа", "D", Color(0xFF0061FF)),
    AppItem("Pinterest", "Идеи и вдохновение", "Фото", "P", Color(0xFFE60023)),
)