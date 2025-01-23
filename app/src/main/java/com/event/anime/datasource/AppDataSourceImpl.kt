package com.event.anime.datasource

import com.event.anime.api.ApiService
import javax.inject.Inject

class AppDataSourceImpl @Inject constructor(private val apiService: ApiService) : AppDataSource {
    override suspend fun animeList() = apiService.animeList()

    override suspend fun animeDetail(id: Int) = apiService.animeDetail(id)
}