package com.example.taskkiparocourse.retrofit

//@JsonClass(generateAdapter = true)
data class SuperNews(
//    @Json(name = "id")
    val id: Int,
//    @Json(name = "title")
    val title: String,
//    @Json(name = "description")
    val description: String,
//    @Json(name = "date")
    val date: String,
//    @Json(name = "keywords")
    val keywords: List<String>,
//    @Json(name = "visible")
    val visible: Boolean
)
