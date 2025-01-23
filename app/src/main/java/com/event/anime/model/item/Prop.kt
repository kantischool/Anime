package com.event.anime.model.item

import com.squareup.moshi.Json

data class Prop(
    @Json(name = "from") val from: Time? = null,
    @Json(name = "to") val to: Time? = null,
)
