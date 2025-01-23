package com.event.anime.api

import com.event.anime.model.response.AnimeDetailResponse
import com.event.anime.model.response.AnimeListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(ApiEndPoint.ANIME_LIST)
    suspend fun animeList(): Response<AnimeListResponse>

    @GET(ApiEndPoint.ANIME_DETAIL)
    suspend fun animeDetail(@Path("id") id: Int): Response<AnimeDetailResponse>
}