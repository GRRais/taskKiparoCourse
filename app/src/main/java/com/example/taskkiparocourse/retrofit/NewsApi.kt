package com.example.taskkiparocourse.retrofit

import retrofit2.http.GET

interface NewsApi {
    @GET("it_news.json")
    suspend fun getNewsById(): SuperNews
}