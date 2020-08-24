package com.example.mfappkotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mfappkotlin.Api.API_KEY
import com.example.mfappkotlin.Api.NewsAPIService
import com.example.mfappkotlin.Model.Article
import com.example.mfappkotlin.Model.Source
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HViewModel : ViewModel() {

    private val newsApiService = NewsAPIService()
    private val disposable = CompositeDisposable()

    var sour = MutableLiveData<List<Source>>()
    var news = MutableLiveData<List<Article>>()



    fun getSourceApı() {
        disposable.add(
            newsApiService.getNewsApi()
                .getSource(API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        sour.value = it.sources
                        println("Вывод")
                        println(it.sources)
                        Log.d("API", it.toString())
                    },
                    {
                        Log.d("API", it.message)
                    }
                )
        )

    }
    fun getArticleApı() {
        disposable.add(
            newsApiService.getNewsApi()
                .getArticle("ru",API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        news.value = it.articles
                        Log.d("API", it.toString())
                    },
                    {
                        Log.d("API", it.message)
                    }
                )
        )

    }

}