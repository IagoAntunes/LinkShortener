package com.iagoaf.linkshortener.features.home.presenter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagoaf.linkshortener.features.home.domain.repository.ILinkRepository
import com.iagoaf.linkshortener.features.home.presenter.state.HomeListener
import com.iagoaf.linkshortener.features.home.presenter.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ILinkRepository
) : ViewModel() {

    private val _state: MutableLiveData<HomeState> = MutableLiveData(HomeState.Idle)
    val state: MutableLiveData<HomeState> get() = _state

    private val _listener: MutableLiveData<HomeListener> = MutableLiveData()
    val listener: MutableLiveData<HomeListener> get() = _listener

    fun createLink(originalLink: String, shortLink: String) {
        viewModelScope.launch {
            _state.value = HomeState.Loading
            val result = repository.createLink(originalLink, shortLink)
            result.onSuccess { link ->
                _listener.value = HomeListener.Success
            }
            result.onError { message ->
                _listener.value = HomeListener.Error(
                    message = message
                )
            }
        }

    }

    fun deleteLink(id: String) {
        viewModelScope.launch {
            val result = repository.deleteLink(id)
            result.onSuccess { link ->
                _listener.value = HomeListener.Success
            }
            result.onError { message ->
                _listener.value = HomeListener.Error(
                    message = message
                )
            }
        }
    }

    fun getLinks() {
        viewModelScope.launch {
            val result = repository.getLinks()
            result.onSuccess { links ->
                _state.value = HomeState.Success(
                    list = links
                )
            }
            result.onError { message ->
                _state.value = HomeState.Error(
                    message = message
                )
            }
        }
    }

}