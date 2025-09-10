package com.haroldcalayan.newsarticles

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


/*
Task Description
You are required to create an Android application that does the following:

1. Fetch News Articles
Use the following API to retrieve news data:https://newsdata.io/api/1/news?apikey=pub_b640af12bd3f4683997516159dc73cb0&country=us&language=en

2. Implement Tab Categories (Technology, Business, Entertainment). API parameter: category

3. Display Articles in a List
Show a scrollable list of news items with the following data per item: (image_url, title, description)

4. Detail Screen Navigation
On clicking a news item card, navigate to a detail screen that shows: (image_url, title, description, creator, link - should be clickable and open the external site in a browser)

Technical Requirements
Language: Kotlin
Architecture: MVVM (Model-View-ViewModel)
UI Framework: Jetpack Compose
Networking: Retrofit with Coroutines

Duration: Until 5pm today

 */

@HiltAndroidApp
class NewsArticlesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogs()
    }

    private fun initLogs() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}