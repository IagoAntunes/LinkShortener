package com.iagoaf.linkshortener.features.home.infra.repository

import com.iagoaf.linkshortener.core.result.BaseResult
import com.iagoaf.linkshortener.features.home.domain.models.LinkModel
import com.iagoaf.linkshortener.features.home.domain.repository.ILinkRepository
import com.iagoaf.linkshortener.features.home.domain.request.CreateLinkRequest
import com.iagoaf.linkshortener.features.home.external.service.LinkService
import javax.inject.Inject

class LinkRepositoryImpl @Inject constructor(
    private val linkService: LinkService
) : ILinkRepository {

    override suspend fun createLink(link: String, nameLink: String): BaseResult<LinkModel> {
        val request = CreateLinkRequest(link, nameLink)
        val response = linkService.createLink(request)
        return if (response.isSuccessful) {
            BaseResult.Success(
                data = response.body()?.data!!
            )
        } else {
            BaseResult.Error(
                message = response.errorBody()?.string() ?: "Unknown error"
            )
        }
    }

    override suspend fun getLinks(): BaseResult<List<LinkModel>> {
        val response = linkService.getLinks()
        return if (response.isSuccessful) {
            BaseResult.Success(
                data = response.body()?.data ?: emptyList()
            )
        } else {
            BaseResult.Error(
                message = response.errorBody()?.string() ?: "Unknown error"
            )
        }
    }

    override suspend fun deleteLink(id: String): BaseResult<List<LinkModel>> {
        val response = linkService.deleteLink(id)
        return if (response.isSuccessful) {
            BaseResult.Success(
                data = response.body()?.data!!
            )
        } else {
            BaseResult.Error(
                message = response.errorBody()?.string() ?: "Unknown error"
            )
        }
    }
}
