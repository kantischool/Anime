package com.event.anime.model.item

import com.squareup.moshi.Json

data class Data(
    @Json(name = "mal_id") val malId: Int? = null,
    @Json(name = "type") val type: String? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "url") val url: String? = null,
)
