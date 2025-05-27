package com.iagoaf.linkshortener.features.home.domain.response

import kotlinx.serialization.Serializable

@Serializable
data class CreateLinkResponse(
    val shortLink: String,
    val originalLink: String,
)