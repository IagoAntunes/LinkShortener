package com.iagoaf.linkshortener.features.home.external.service

import com.iagoaf.linkshortener.services.http.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = RetrofitClient.instance

    @Provides
    @Singleton
    fun provideLinkService(retrofit: Retrofit): LinkService {
        return retrofit.create(LinkService::class.java)
    }
}