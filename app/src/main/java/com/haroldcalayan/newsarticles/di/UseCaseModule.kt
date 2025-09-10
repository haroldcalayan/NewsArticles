package com.haroldcalayan.newsarticles.di

import com.haroldcalayan.newsarticles.domain.repository.NewsArticleRepository
import com.haroldcalayan.newsarticles.domain.usecase.GetNewsArticleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun providesGetNewsArticleUseCase(repository: NewsArticleRepository) = GetNewsArticleUseCase(repository)

}