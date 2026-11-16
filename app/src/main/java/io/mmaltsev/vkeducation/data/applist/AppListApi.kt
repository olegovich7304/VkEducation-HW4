package io.mmaltsev.vkeducation.data.applist

import retrofit2.http.GET

interface AppListApi {
    @GET("catalog")
    suspend fun getCatalog(): List<AppListItemDto>
}