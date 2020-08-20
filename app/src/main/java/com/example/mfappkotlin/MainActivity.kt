package com.example.mfappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.MutableLiveData
import com.example.mfappkotlin.Api.NewsAPIService
import com.example.mfappkotlin.Fragment.ChannelFragment
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

        val fragmentManager =supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        val firstFragment= ChannelFragment()
        fragmentTransaction.add(R.id.fragment,firstFragment).commit()
    }

}

