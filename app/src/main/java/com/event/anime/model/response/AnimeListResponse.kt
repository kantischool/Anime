package com.event.anime.model.response

import com.event.anime.model.item.Anime
import com.event.anime.model.item.Pagination
import com.squareup.moshi.Json

data class AnimeListResponse(
    @Json(name = "pagination") val pagination: Pagination? = null,
    @Json(name = "data") val data: List<Anime>? = null
)
