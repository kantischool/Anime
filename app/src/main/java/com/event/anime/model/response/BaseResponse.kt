package com.event.anime.model.response

import com.squareup.moshi.Json

data class BaseResponse<T>(
    @Json(name = "message") val message: String? = null,
    @Json(name = "data") val data: T? = null,
)

data class ErrorResponse(
    @Json(name = "message") val message: String? = null,
)
