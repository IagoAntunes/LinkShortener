package com.iagoaf.linkshortener.features.home.presenter.state

sealed class HomeListener {
    object Loading : HomeListener()
    object Success : HomeListener()
    data class Error(val message: String) : HomeListener()
    data class ShowToast(val message: String) : HomeListener()
    data class ShowSnackBar(val message: String) : HomeListener()
}