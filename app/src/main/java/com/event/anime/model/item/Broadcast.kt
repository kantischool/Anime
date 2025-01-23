package com.event.anime.model.item

import com.squareup.moshi.Json

data class Broadcast(
    @Json(name = "day") val day: String? = null,
    @Json(name = "time") val time: String? = null,
    @Json(name = "timezone") val timezone: String? = null,
    @Json(name = "string") val string: String? = null,
)
