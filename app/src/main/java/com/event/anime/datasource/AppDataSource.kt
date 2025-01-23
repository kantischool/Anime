package com.event.anime.datasource

import com.event.anime.model.response.AnimeDetailResponse
import com.event.anime.model.response.AnimeListResponse
import retrofit2.Response

interface AppDataSource {
    suspend fun animeList(): Response<AnimeListResponse>

    suspend fun animeDetail(id: Int): Response<AnimeDetailResponse>
}