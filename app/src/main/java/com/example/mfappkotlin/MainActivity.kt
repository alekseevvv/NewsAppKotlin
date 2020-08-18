package com.example.mfappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.MutableLiveData
import com.example.mfappkotlin.Api.NewsAPIService
import com.example.mfappkotlin.Model.Article
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Copy.Companion.invoke
import org.kodein.di.Kodein.Companion.invoke

class MainActivity : AppCompatActivity() {

   // val txt = findViewById<TextView>(R.id.textView3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener(clickListener)
    }

    val clickListener = View.OnClickListener { view->
        textView3.text = "Рбаотет,бля"
        getDataApı()
    }


    private val newsApiService = NewsAPIService()
    private val disposable = CompositeDisposable()
    var news = MutableLiveData<List<Article>>()


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

