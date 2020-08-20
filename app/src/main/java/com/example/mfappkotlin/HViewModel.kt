package com.example.mfappkotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mfappkotlin.Api.NewsAPIService
import com.example.mfappkotlin.Model.Article
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HViewModel : ViewModel() {

    private val newsApiService = NewsAPIService()
    private val disposable = CompositeDisposable()



    var news = MutableLiveData<List<Article>>()



    fun run() {
        getDataApı()
    }

    private fun getDataApı() {

        disposable.add(
            newsApiService.getNewsApi()
                .getTopHeadlines("ru", "b74de9f058fd49fda341fbc1d9c9bc67")
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