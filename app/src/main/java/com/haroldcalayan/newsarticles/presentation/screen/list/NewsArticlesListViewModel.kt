package com.haroldcalayan.newsarticles.presentation.screen.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haroldcalayan.newsarticles.common.util.Response
import com.haroldcalayan.newsarticles.data.model.NewsArticlesResponse
import com.haroldcalayan.newsarticles.domain.usecase.GetNewsArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NewsArticlesListViewModel @Inject constructor(
    private val getNewsArticleUseCase: GetNewsArticleUseCase
) : ViewModel() {

    private val _newsArticleState = MutableStateFlow(NewsArticlesResponse())
    val newsArticleState: StateFlow<NewsArticlesResponse> = _newsArticleState.asStateFlow()

    init {
        getNewsArticles("Technology")
    }

    fun getNewsArticles(category: String) {
        Timber.d("getNewsArticles()")
        getNewsArticleUseCase(category).onEach { response ->
            when(response) {
                is Response.Success -> {
                    Timber.d("SUCCESS")
                    _newsArticleState.value = response.data ?: NewsArticlesResponse()
                }
                is Response.Error -> {
                    Timber.d("Error")
                    Timber.d(response.message)
                }
                is Response.Loading -> {
                    Timber.d("LOADING")
                }
            }
        }.launchIn(viewModelScope)
    }
}