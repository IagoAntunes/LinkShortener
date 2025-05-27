package com.iagoaf.linkshortener.core.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val isSuccess: Boolean,
    val codeError: String,
    val data: T,
)