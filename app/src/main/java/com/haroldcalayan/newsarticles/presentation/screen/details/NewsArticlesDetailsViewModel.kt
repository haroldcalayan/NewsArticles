package com.haroldcalayan.newsarticles.presentation.screen.details

import androidx.lifecycle.ViewModel
import com.haroldcalayan.newsarticles.domain.usecase.GetNewsArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsArticlesDetailsViewModel @Inject constructor(
    private val newsArticleUseCase: GetNewsArticleUseCase
) : ViewModel()