package com.example.taskkiparocourse

//@JsonClass(generateAdapter = true)
data class SuperNews(
    val name: String?,
    val location: String?,
    val news: List<NewsCell>?
)
