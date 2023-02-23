package com.example.taskkiparocourse

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/static/it_news.json")
    suspend fun getNewsById(): Response<SuperNews>
}