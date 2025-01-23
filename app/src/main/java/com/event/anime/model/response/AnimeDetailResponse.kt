package com.event.anime.model.response

import com.event.anime.model.item.Anime
import com.squareup.moshi.Json

data class AnimeDetailResponse(
    @Json(name = "data") val data : Anime? = null
)
