package com.haroldcalayan.newsarticles.data.repository

import com.haroldcalayan.newsarticles.data.model.NewsArticlesResponse
import com.haroldcalayan.newsarticles.data.source.remote.ApiService
import com.haroldcalayan.newsarticles.domain.repository.NewsArticleRepository
import timber.log.Timber

class NewsArticleRepositoryImpl(private val apiService: ApiService) : NewsArticleRepository {

    override suspend fun getNewsArticle(category: String): NewsArticlesResponse {
        return apiService.getNewsArticles(category = category)
    }
}