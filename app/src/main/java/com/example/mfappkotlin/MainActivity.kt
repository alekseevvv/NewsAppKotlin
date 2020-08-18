package com.example.mfappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.mfappkotlin.Api.NewsApi
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
    }






}

