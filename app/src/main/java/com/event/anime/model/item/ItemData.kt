package com.event.anime.model.item

import com.squareup.moshi.Json

data class ItemData(
    @Json(name = "count") val count: Int? = null,
    @Json(name = "total") val total: Int? = null,
    @Json(name = "per_page") val perPage: Int? = null
)
