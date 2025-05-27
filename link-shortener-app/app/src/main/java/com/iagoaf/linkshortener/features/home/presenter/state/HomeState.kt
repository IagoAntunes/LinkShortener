package com.iagoaf.linkshortener.features.home.presenter.state

import com.iagoaf.linkshortener.features.home.domain.models.LinkModel

sealed class HomeState {
    object Idle : HomeState()
    object Loading : HomeState()
    data class Success(
        val list: List<LinkModel>
    ) : HomeState()

    data class Error(val message: String) : HomeState()
}