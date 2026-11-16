package io.mmaltsev.vkeducation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.mmaltsev.vkeducation.data.applist.AppListApi
import io.mmaltsev.vkeducation.data.applist.AppListMapper
import io.mmaltsev.vkeducation.data.applist.AppListRepositoryImpl
import io.mmaltsev.vkeducation.domain.applist.AppListRepository
import io.mmaltsev.vkeducation.domain.applist.GetAppListUseCase
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppListModule {

    @Provides
    @Singleton
    fun provideAppListApi(retrofit: Retrofit): AppListApi =
        retrofit.create(AppListApi::class.java)

    @Provides
    @Singleton
    fun provideAppListMapper(): AppListMapper = AppListMapper()

    @Provides
    @Singleton
    fun provideAppListRepository(
        api: AppListApi,
        mapper: AppListMapper,
    ): AppListRepository = AppListRepositoryImpl(api, mapper)

    @Provides
    @Singleton
    fun provideGetAppListUseCase(
        repository: AppListRepository,
    ): GetAppListUseCase = GetAppListUseCase(repository)
}