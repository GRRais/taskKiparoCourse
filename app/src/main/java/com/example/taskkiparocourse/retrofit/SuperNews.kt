package com.example.taskkiparocourse.retrofit

import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class SuperNews(
    @SerializedName("name")
    val name: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("news")
    val news: List<News>?
)
