package com.iagoaf.linkshortener.features.home.domain.response

import com.iagoaf.linkshortener.core.response.BaseResponse
import com.iagoaf.linkshortener.features.home.domain.models.LinkModel
import kotlinx.serialization.Serializable

@Serializable
class GetLinksResponse(
    val response: BaseResponse<List<LinkModel>>
)
