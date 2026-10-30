package io.mmaltsev.vkeducation.data.applist

import io.mmaltsev.vkeducation.domain.applist.AppListItem
import io.mmaltsev.vkeducation.domain.applist.AppListRepository

class AppListRepositoryImpl(
    private val api: AppListApi,
    private val mapper: AppListMapper,
) : AppListRepository {

    override suspend fun getApps(): List<AppListItem> =
        api.getApps().map(mapper::toDomain)
}