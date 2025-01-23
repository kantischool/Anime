package com.event.anime.model.item

import com.squareup.moshi.Json

data class Time(
    @Json(name = "day") val hour: Int? = null,
    @Json(name = "month") val minute: Int? = null,
    @Json(name = "year") val second: Int? = null,
)
