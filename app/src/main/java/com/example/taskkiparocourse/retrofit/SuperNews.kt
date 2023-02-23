package com.example.taskkiparocourse.retrofit

import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class SuperNews(
    val name: String?,
    val location: String?,
    val news: List<News>?
)
