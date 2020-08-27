package com.example.mfappkotlin.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mfappkotlin.Model.Source

@Database(entities = arrayOf(Article::class, Source::class), version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun articleDao():ArticlesDAO
    abstract fun channelDao():ChannelDAO
}