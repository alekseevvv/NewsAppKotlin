package com.example.mfappkotlin.DB

import androidx.room.Dao
import retrofit2.http.Query

@Dao
interface ArticlesDAO {
    @Query ("SELECT * FROM article")
    fun getArticle(): List<Article>
}