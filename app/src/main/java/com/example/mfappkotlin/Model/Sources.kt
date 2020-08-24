package com.example.mfappkotlin.Model

import com.google.gson.annotations.SerializedName

data class Sources(
    @SerializedName("sources")
    val sources: List<Source>,
    @SerializedName("status")
    val status: String
)