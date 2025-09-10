package com.haroldcalayan.newsarticles.common.util

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

inline fun <reified T> provideAPi(url: String, httpClient: OkHttpClient) : T {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(T::class.java)
}