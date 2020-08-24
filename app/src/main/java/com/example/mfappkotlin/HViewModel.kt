package com.example.mfappkotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mfappkotlin.Api.NewsAPIService
import com.example.mfappkotlin.Model.Article
import com.example.mfappkotlin.Model.Source
import com.example.mfappkotlin.Model.Sources
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HViewModel : ViewModel() {

    private val newsApiService = NewsAPIService()
    private val disposable = CompositeDisposable()

    var news = MutableLiveData<List<Source>>()

    fun run() {
        getDataApı()
    }

    private fun getDataApı() {

        disposable.add(
            newsApiService.getNewsApi()
                .getSource("b74de9f058fd49fda341fbc1d9c9bc67")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        news.value = it.sources
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

}