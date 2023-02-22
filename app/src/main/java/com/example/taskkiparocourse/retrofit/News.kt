package com.example.taskkiparocourse.retrofit

//@JsonClass(generateAdapter = true)
data class News(
//    @Json(name = "name")
    val name: String,
//    @Json(name = "location")
    val location: String,
//    @Json(name = "news")
    val news: List<SuperNews>
)
