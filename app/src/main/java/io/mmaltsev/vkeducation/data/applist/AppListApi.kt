package io.mmaltsev.vkeducation.data.applist

import kotlinx.coroutines.delay

// Представим, что этот класс ходит в сеть.
class AppListApi {

    suspend fun getApps(): List<AppListItemDto> {
        delay(1000) // имитация сетевого запроса
        return listOf(
            AppListItemDto(
                id = "youtube",
                name = "YouTube",
                description = "Просмотр видео и каналов",
                category = "Развлечения",
                icon = "Y",
                color = "#FF0033",
            ),
            AppListItemDto(
                id = "telegram",
                name = "Telegram",
                description = "Сообщения и звонки",
                category = "Общение",
                icon = "T",
                color = "#229ED9",
            ),
            AppListItemDto(
                id = "spotify",
                name = "Spotify",
                description = "Музыка и подкасты",
                category = "Музыка",
                icon = "S",
                color = "#1DB954",
            ),
            AppListItemDto(
                id = "google-maps",
                name = "Google Maps",
                description = "Карты и навигация",
                category = "Путешествия",
                icon = "M",
                color = "#4285F4",
            ),
            AppListItemDto(
                id = "gmail",
                name = "Gmail",
                description = "Электронная почта",
                category = "Работа",
                icon = "G",
                color = "#EA4335",
            ),
            AppListItemDto(
                id = "duolingo",
                name = "Duolingo",
                description = "Изучение иностранных языков",
                category = "Образование",
                icon = "D",
                color = "#58CC02",
            ),
        )
    }
}