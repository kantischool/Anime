package com.event.anime.model.item

import com.squareup.moshi.Json

data class Aired(
    @Json(name = "from") val from: String? = null,
    @Json(name = "to") val to: String? = null,
    @Json(name = "prop") val prop: Prop? = null,
    @Json(name = "string") val string: String? = null,
)
