package io.mmaltsev.vkeducation.data.applist

import kotlinx.coroutines.delay

// Представим, что этот класс ходит в сеть за рейтингом.
class RatingApi {

    suspend fun getRating(id: String): Float {
        delay(1500) // эмуляция сетевого запроса
        return (30..50).random() / 10f
    }
}