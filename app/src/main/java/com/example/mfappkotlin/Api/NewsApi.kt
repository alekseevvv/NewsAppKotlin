package com.example.mfappkotlin.Api

import com.example.mfappkotlin.Model.NewsModel
import com.example.mfappkotlin.Model.Sources
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "b74de9f058fd49fda341fbc1d9c9bc67"

interface NewsApi {
    @GET("/v2/top-headlines")
    fun getArticle(
        @Query("country") country : String,
        @Query("apiKey") apiKey : String ): Single<NewsModel>

    @GET("/v2/sources")
    fun getSource(
        @Query("apiKey") apiKey : String ): Single<Sources>

}