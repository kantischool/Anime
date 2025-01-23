package com.event.anime.repository

import com.event.anime.api.ApiRequest
import com.event.anime.api.ResponseState
import com.event.anime.api.Status
import com.event.anime.datasource.AppDataSource
import com.event.anime.model.item.Anime
import com.event.anime.model.response.AnimeDetailResponse
import com.event.anime.model.response.AnimeListResponse
import com.event.anime.model.response.BaseResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val apiRequest: ApiRequest,
    private val appDataSource: AppDataSource
) {
    fun animeList(): Flow<ResponseState<AnimeListResponse>> = flow {
        emit(ResponseState.Loading(Status.LOADING))
        val data = apiRequest.makeRequest {
            appDataSource.animeList()
        }
        emit(data)
    }

    fun animeDetail(id: Int): Flow<ResponseState<AnimeDetailResponse>> = flow {
        emit(ResponseState.Loading(Status.LOADING))
        val data = apiRequest.makeRequest {
            appDataSource.animeDetail(id)
        }
        emit(data)
    }
}