package com.haroldcalayan.newsarticles.di

import com.haroldcalayan.newsarticles.BuildConfig
import com.haroldcalayan.newsarticles.common.Constants
import com.haroldcalayan.newsarticles.common.util.provideAPi
import com.haroldcalayan.newsarticles.data.source.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesHttpClient(okHttpClient: OkHttpClient.Builder) : OkHttpClient {
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideHttpClientBuilder(
        loggingInterceptor: HttpLoggingInterceptor
    ) : OkHttpClient.Builder {
        return OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor)
        }
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideNewsArticlesApi(client: OkHttpClient) : ApiService {
        return provideAPi(Constants.API_BASE_URL, client)
    }
}