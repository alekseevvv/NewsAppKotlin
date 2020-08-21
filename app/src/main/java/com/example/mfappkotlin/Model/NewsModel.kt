package com.example.mfappkotlin.Model


import com.example.mfappkotlin.Model.Article
import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("source")
    val source: List<Source>
)