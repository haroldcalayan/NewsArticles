package com.haroldcalayan.newsarticles.data.model

import com.google.gson.annotations.SerializedName

data class NewsArticlesResponse(
    val status: String? = null,
    val totalResults: Long? = null,
    val results: List<NewsArticleListItem> = emptyList(),
    val nextPage: String? = null,
)

data class NewsArticleListItem(
    @SerializedName("article_id")
    val articleId: String,
    val title: String,
    val link: String,
    val keywords: List<String>?,
    val creator: List<String>?,
    val description: String,
    val content: String,
    val pubDate: String,
    @SerializedName("pubDateTZ")
    val pubDateTz: String,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("video_url")
    val videoUrl: Any?,
    @SerializedName("source_id")
    val sourceId: String,
    @SerializedName("source_name")
    val sourceName: String,
    @SerializedName("source_priority")
    val sourcePriority: Long,
    @SerializedName("source_url")
    val sourceUrl: String,
    @SerializedName("source_icon")
    val sourceIcon: String,
    val language: String,
    val country: List<String>,
    val category: List<String>,
    val sentiment: String,
    @SerializedName("sentiment_stats")
    val sentimentStats: String,
    @SerializedName("ai_tag")
    val aiTag: String,
    @SerializedName("ai_region")
    val aiRegion: String,
    @SerializedName("ai_org")
    val aiOrg: String,
    @SerializedName("ai_summary")
    val aiSummary: String,
    @SerializedName("ai_content")
    val aiContent: String,
    val duplicate: Boolean,
)
