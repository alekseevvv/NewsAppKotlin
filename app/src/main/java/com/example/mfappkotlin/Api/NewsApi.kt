package com.example.mfappkotlin.Api

import com.example.mfappkotlin.Model.NewsModel
import com.example.mfappkotlin.Model.Source
import com.example.mfappkotlin.Model.Sources
import io.reactivex.Single
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "b74de9f058fd49fda341fbc1d9c9bc67"
const val BASE_URL = "https://newsapi.org/v2/"

/*companion object {
    val instance : NewsApiClient by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        retrofit.create(NewsApiClient::class.java)
    }
}*/

interface NewsApi {
    @GET("/v2/top-headlines")
    fun getNews(
        @Query("country") country : String,
        @Query("apiKey") apiKey : String ): Single<NewsModel>

    @GET("/v2/sources")
    fun getSource(
        @Query("apiKey") apiKey : String ): Single<Sources>

}