package com.haroldcalayan.newsarticles.domain.repository

import com.haroldcalayan.newsarticles.data.model.NewsArticlesResponse

interface NewsArticleRepository {

    suspend fun getNewsArticle(category: String): NewsArticlesResponse
}