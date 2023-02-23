package com.example.taskkiparocourse.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface SuperNewsApi {
    @GET("static/it_news.json")
    suspend fun getNewsById(): Response<SuperNews>
}