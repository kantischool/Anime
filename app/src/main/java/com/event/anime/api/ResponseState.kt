package com.event.anime.api

import com.event.anime.model.response.ErrorResponse

sealed class ResponseState<T>(
    val status: Status? = null,
    val responseCode: Int? = null,
    val message: String? = null,
    val data: T? = null,
    val error: ErrorResponse? = null,
) {
    class Loading<T>(
        status: Status? = null,
    ) : ResponseState<T>(status = status)

    class Success<T>(
        status: Status? = null,
        responseCode: Int? = null,
        message: String? = null,
        data: T? = null,
    ) : ResponseState<T>(
        status = status,
        responseCode = responseCode,
        message = message,
        data = data
    )

    class Error<T>(
        status: Status? = null,
        responseCode: Int? = null,
        error: ErrorResponse? = null,
    ) : ResponseState<T>(status = status, responseCode = responseCode, error = error)
}

enum class Status {
    LOADING,
    SUCCESS,
    ERROR,
}