package com.haroldcalayan.newsarticles.common.util

import okhttp3.Route

sealed class Screen(val route: String) {

    data object NewsArticleListScreen: Screen(route = "news_article_list_screen")
    data object NewsArticleDetailsScreen: Screen(route = "news_article_details_screen")
}