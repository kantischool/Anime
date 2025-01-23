package com.event.anime.model.item

import com.squareup.moshi.Json

data class Image(
    @Json(name = "image_url") val imageUrl: String? = null,
    @Json(name = "small_image_url") val smallImageUrl: String? = null,
    @Json(name = "medium_image_url") val mediumImageUrl: String? = null,
    @Json(name = "large_image_url") val largeImageUrl: String? = null,
    @Json(name = "maximum_image_url") val maximumImageUrl: String? = null,
)
