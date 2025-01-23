package com.event.anime.model.item

import com.squareup.moshi.Json

data class Pagination(
    @Json(name = "last_visible_page") val lastVisiblePage: Int? = null,
    @Json(name = "has_next_page") val hasNextPage: Boolean? = null,
    @Json(name = "current_page") val currentPage: Int? = null,
    @Json(name = "items") val items: ItemData? = null,
)
