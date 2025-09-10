package com.haroldcalayan.newsarticles.di

import com.haroldcalayan.newsarticles.data.repository.NewsArticleRepositoryImpl
import com.haroldcalayan.newsarticles.data.source.remote.ApiService
import com.haroldcalayan.newsarticles.domain.repository.NewsArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsArticleRepository(apiService: ApiService) : NewsArticleRepository {
        return NewsArticleRepositoryImpl(apiService)
    }
}