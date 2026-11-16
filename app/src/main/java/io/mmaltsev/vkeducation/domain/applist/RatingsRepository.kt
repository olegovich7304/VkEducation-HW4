package io.mmaltsev.vkeducation.domain.applist

interface RatingsRepository {
    /** Рейтинги запрашиваются по очереди: следующий только после предыдущего. */
    suspend fun loadRatingsSequentially(ids: List<String>): Map<String, Float>

    /** Рейтинги всех приложений запрашиваются одновременно. */
    suspend fun loadRatingsInParallel(ids: List<String>): Map<String, Float>
}