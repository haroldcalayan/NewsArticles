package com.haroldcalayan.newsarticles.presentation.screen.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.haroldcalayan.newsarticles.common.util.Screen
import com.haroldcalayan.newsarticles.common.util.encodeForRoute
import com.haroldcalayan.newsarticles.data.model.NewsArticleListItem
import com.haroldcalayan.newsarticles.data.model.NewsArticlesResponse

@Composable
fun NewsArticlesListScreen(
    navController: NavHostController,
    viewModel: NewsArticlesListViewModel = hiltViewModel()
) {

    val state = viewModel.newsArticleState.collectAsState().value

    Column {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { viewModel.getNewsArticles("Technology")}
            ) {
                Text(
                    text = "Technology"
                )
            }
            Button(
                onClick = { viewModel.getNewsArticles("Business")}
            ) {
                Text(
                    text = "Business"
                )
            }
            Button(
                onClick = { viewModel.getNewsArticles("Entertainment")}
            ) {
                Text(
                    text = "Entertainment"
                )
            }
        }

        Spacer(modifier = Modifier.size(24.dp))

        if (state.results.isEmpty()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                state = rememberLazyListState(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(state.results) { _, item ->
                    ListItem(item, { navController.navigate(
                        "${Screen.NewsArticleDetailsScreen.route}/${item.imageUrl.orEmpty().encodeForRoute()}/${item.title}/${item.creator}/${item.description}/${item.link.encodeForRoute()}"
                    ) })
                }
            }
        }
    }
}

@Composable
fun ListItem(
    state: NewsArticleListItem,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier.clickable { onClick() }.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AsyncImage(
            model = state.imageUrl,
            contentDescription = null,
            modifier = Modifier.size(72.dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = state.title,
                maxLines = 1,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = state.description,
                maxLines = 2,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}