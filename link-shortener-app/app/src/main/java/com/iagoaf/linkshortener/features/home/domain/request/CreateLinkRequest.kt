package com.iagoaf.linkshortener.features.home.domain.request

import kotlinx.serialization.Serializable

@Serializable
data class CreateLinkRequest(
    val originalLink: String,
    val shortLink: String
)
