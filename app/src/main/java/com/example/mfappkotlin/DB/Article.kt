package com.example.mfappkotlin.DB


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mfappkotlin.Model.Source
import com.google.gson.annotations.SerializedName
@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int,
    @ColumnInfo(name = "author")
    @SerializedName("author")
    val author: String,
    @ColumnInfo(name = "content")
    @SerializedName("content")
    val content: Any,
    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String,
    @ColumnInfo(name = "publishedAt")
    @SerializedName("publishedAt")
    val publishedAt: String,
    @ColumnInfo(name = "source")
    @SerializedName("source")
    val source: Source,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String,
    @ColumnInfo(name = "url")
    @SerializedName("url")
    val url: String,
    @ColumnInfo(name = "urlToImage")
    @SerializedName("urlToImage")
    val urlToImage: String
)