package com.example.taskkiparocourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskkiparocourse.databinding.ActivityNewsJsonBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class NewsJSONActivity : AppCompatActivity() {

    var itemsArray: ArrayList<NewsCell> = ArrayList()
    lateinit var adapter: RVAdapter
    private lateinit var binding: ActivityNewsJsonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsJsonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.jsonResultsTextview.text = ""

        initRecyclerView()
        parseJSON()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.jsonResultsRecyclerview.layoutManager = layoutManager
        binding.jsonResultsRecyclerview.setHasFixedSize(true)
        val dividerItemDecoration =
            DividerItemDecoration(
                binding.jsonResultsRecyclerview.context,
                layoutManager.orientation
            )
        ContextCompat.getDrawable(this, R.drawable.line_divider)
            ?.let { drawable -> dividerItemDecoration.setDrawable(drawable) }
        binding.jsonResultsRecyclerview.addItemDecoration(dividerItemDecoration)
    }

    private fun parseJSON() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit
            .Builder()
            .baseUrl(jsonFileUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getNewsById()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val news = response.body()?.news
                    if (news != null) {
                        for (i in 0 until news.count()) {

                            val id = news[i].id ?: "N/A"
                            Log.d("ID: ", id as String)

                            val title = news[i].title ?: "N/A"
                            Log.d("TITLE: ", title)

                            val description = news[i].description ?: "N/A"
                            Log.d("DESCRIPTION: ", description)

                            val date = news[i].date ?: "N/A"
                            Log.d("DATE: ", date)

                            val keywords = news[i].keywords ?: "N/A"
                            Log.d("KEYWORDS: ", (keywords as List<*>).toString())

                            val visible = news[i].visible ?: "N/A"
                            Log.d("VISIBLE: ", visible as String)

                            val model =
                                NewsCell(
                                    id,
                                    title,
                                    description,
                                    date,
                                    keywords as List<String>,
                                    visible as Boolean
                                )
                            itemsArray.add(model)

                            adapter = RVAdapter(itemsArray)
                            adapter.notifyDataSetChanged()
                        }
                    }
                    binding.jsonResultsRecyclerview.adapter = adapter
                } else {
                    Log.e("RETROFIT_ERROR", response.code().toString())
                }
            }
        }
    }
}
