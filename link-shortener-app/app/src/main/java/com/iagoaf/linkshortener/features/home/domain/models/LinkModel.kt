package com.iagoaf.linkshortener.features.home.domain.models

import kotlinx.serialization.Serializable


@Serializable
data class LinkModel(
    val id: String,
    val originalLink: String,
    val shortLink: String,
    val access: Int
)