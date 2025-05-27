package com.iagoaf.linkshortener.features.home.domain.repository

import com.iagoaf.linkshortener.core.result.BaseResult
import com.iagoaf.linkshortener.features.home.domain.models.LinkModel

interface ILinkRepository {
    suspend fun createLink(link: String, nameLink: String): BaseResult<LinkModel>
    suspend fun getLinks(): BaseResult<List<LinkModel>>
    suspend fun deleteLink(id: String): BaseResult<List<LinkModel>>
}