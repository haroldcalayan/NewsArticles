package com.haroldcalayan.newsarticles.presentation.screen.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.haroldcalayan.newsarticles.presentation.screen.list.NewsArticlesListViewModel

@Composable
fun NewsArticleDetailsScreen(
    imageUrl: String,
    title: String,
    description: String,
    link: String,
    creator: String,
) {

    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = creator,
            style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            modifier = Modifier.clickable { uriHandler.openUri(link) },
            text = link,
            style = MaterialTheme.typography.bodySmall.copy(
                color = Color.Blue
            )
        )
    }
}