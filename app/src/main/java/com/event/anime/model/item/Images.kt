package com.event.anime.model.item

import com.squareup.moshi.Json

data class Images(
    @Json(name = "jpg") val jpg: Image? = null,
    @Json(name = "webp") val webp: Image? = null

)
