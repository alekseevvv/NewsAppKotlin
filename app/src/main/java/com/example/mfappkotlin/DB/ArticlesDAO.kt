package com.example.mfappkotlin.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.mfappkotlin.Model.Article
import retrofit2.http.Query

@Dao
interface ArticlesDAO {
    @Query ("SELECT * from article")
    fun getArticle():LiveData<List<Article>>
}