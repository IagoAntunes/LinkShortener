package com.iagoaf.linkshortener.features.home.external.service

import com.iagoaf.linkshortener.core.response.BaseResponse
import com.iagoaf.linkshortener.features.home.domain.models.LinkModel
import com.iagoaf.linkshortener.features.home.domain.request.CreateLinkRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LinkService {
    companion object {
        const val BASE_URL = "/url-shortener"
    }

    @POST(BASE_URL)
    suspend fun createLink(
        @Body request: CreateLinkRequest
    ): Response<BaseResponse<LinkModel>>

    @GET(BASE_URL)
    suspend fun getLinks(): Response<BaseResponse<List<LinkModel>>>

    @DELETE("$BASE_URL/{id}")
    suspend fun deleteLink(
        @Path("id") id: String
    ): Response<BaseResponse<List<LinkModel>>>
}