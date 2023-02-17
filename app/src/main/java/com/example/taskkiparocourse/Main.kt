package com.example.taskkiparocourse

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter

fun main() {
    println("Нажмите 1, чтобы скачать JSON, 2 - XML")
    println()
    when(readLine()) {
        "1" -> loadJsonFile()
        "2" -> print("x == 2")
        else -> {
            print("Введенное значение отлично от 1 и 2")
        }
    }
}

@OptIn(ExperimentalStdlibApi::class)
fun loadJsonFile() {
    val jsonFile = "https://api2.kiparo.com/static/it_news.json"
    val moshi: Moshi = Moshi.Builder().build()
    val jsonAdapter: JsonAdapter<News> = moshi.adapter()

    val news = jsonAdapter.fromJson(jsonFile)
    println(news)
}