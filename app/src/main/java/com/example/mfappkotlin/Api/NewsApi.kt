package com.example.mfappkotlin.Api

import com.example.mfappkotlin.Model.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "b74de9f058fd49fda341fbc1d9c9bc67"
const val BASE_URL = "https://newsapi.org/v2/"

interface NewsApi {
    @GET("/v2/top-headlines")
    fun getTopHeadlines(
        @Query("country") country : String = "ru",
        @Query("apiKey") apiKey : String ): Response<NewsModel>


}