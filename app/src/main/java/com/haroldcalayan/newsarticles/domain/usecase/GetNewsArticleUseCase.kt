package com.haroldcalayan.newsarticles.domain.usecase

import com.haroldcalayan.newsarticles.common.util.Response
import com.haroldcalayan.newsarticles.data.model.NewsArticlesResponse
import com.haroldcalayan.newsarticles.domain.repository.NewsArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class GetNewsArticleUseCase @Inject constructor(
    private val newsArticleRepository: NewsArticleRepository
) {

    operator fun invoke(category: String): Flow<Response<NewsArticlesResponse>> = flow {
        Timber.d("invoke()")
        emit(Response.Loading())

        try {
            val articles = newsArticleRepository.getNewsArticle(category)
            emit(Response.Success(articles))
        } catch (e: Exception) {
            emit(Response.Error(null, e.message ?: "Unknown Error"))
        }
    }

}