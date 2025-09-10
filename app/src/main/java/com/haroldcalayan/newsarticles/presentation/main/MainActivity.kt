package com.haroldcalayan.newsarticles.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haroldcalayan.newsarticles.common.util.Screen
import com.haroldcalayan.newsarticles.common.util.decodeForRoute
import com.haroldcalayan.newsarticles.common.util.encodeForRoute
import com.haroldcalayan.newsarticles.presentation.screen.details.NewsArticleDetailsScreen
import com.haroldcalayan.newsarticles.presentation.screen.list.NewsArticlesListScreen
import com.haroldcalayan.newsarticles.ui.theme.NewsArticlesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsArticlesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                       navController = navController,
                        startDestination = Screen.NewsArticleListScreen.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.NewsArticleListScreen.route) {
                            NewsArticlesListScreen(navController)
                        }
                        composable("${Screen.NewsArticleDetailsScreen.route}/{imageUrl}/{title}/{creator}/{description}/{link}") {
                            it.arguments?.let { args ->
                                val imageUrl = args.getString("imageUrl").orEmpty()
                                val title = args.getString("title").orEmpty()
                                val creator = args.getString("creator").orEmpty()
                                val description = args.getString("description").orEmpty()
                                val link = args.getString("link").orEmpty()

                                NewsArticleDetailsScreen(
                                    imageUrl = imageUrl.decodeForRoute(),
                                    title = title,
                                    creator = creator,
                                    description = description,
                                    link = link.decodeForRoute(),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}