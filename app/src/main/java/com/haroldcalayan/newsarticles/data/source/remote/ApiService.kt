package com.haroldcalayan.newsarticles.data.source.remote

import com.haroldcalayan.newsarticles.data.model.NewsArticlesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/1/news?")
    suspend fun getNewsArticles(
        @Query("apiKey") apiKey: String =  "pub_b640af12bd3f4683997516159dc73cb0",
        @Query("country") country: String =  "us",
        @Query("language") language: String =  "en",
        @Query("category") category: String =  ""
    ): NewsArticlesResponse

    @GET("/api/1/news/:id")
    suspend fun getNewsArticleDetails() {

    }

}