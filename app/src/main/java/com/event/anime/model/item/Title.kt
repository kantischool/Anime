package com.event.anime.model.item

import com.squareup.moshi.Json

data class Title(
    @Json(name = "type") val type: String? = null,
    @Json(name = "title") val title: String? = null,
)
