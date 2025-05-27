package com.iagoaf.linkshortener.features.home.domain.repository.modules

import com.iagoaf.linkshortener.features.home.domain.repository.ILinkRepository
import com.iagoaf.linkshortener.features.home.infra.repository.LinkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindLinkRepository(
        impl: LinkRepositoryImpl
    ): ILinkRepository
}
