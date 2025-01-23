package com.event.anime.model.item

import com.squareup.moshi.Json

data class Trailer(
    @Json(name = "youtube_id") val youtubeId: String? = null,
    @Json(name = "url") val url: String? = null,
    @Json(name = "embed_url") val embedUrl: String? = null,
    @Json(name = "images") val images: Image? = null,
)

