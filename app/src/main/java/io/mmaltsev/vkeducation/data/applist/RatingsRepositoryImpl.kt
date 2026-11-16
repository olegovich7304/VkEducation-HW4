package io.mmaltsev.vkeducation.data.applist

import io.mmaltsev.vkeducation.domain.applist.RatingsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class RatingsRepositoryImpl(
    private val api: RatingApi,
) : RatingsRepository {

    override suspend fun loadRatingsSequentially(ids: List<String>): Map<String, Float> {
        val result = mutableMapOf<String, Float>()
        for (id in ids) {
            result[id] = api.getRating(id)
        }
        return result
    }

    override suspend fun loadRatingsInParallel(ids: List<String>): Map<String, Float> =
        coroutineScope {
            ids.map { id -> async { id to api.getRating(id) } }
                .awaitAll()
                .toMap()
        }
}