package io.mmaltsev.vkeducation.domain.applist

interface AppListRepository {
    suspend fun getApps(): List<AppListItem>
}