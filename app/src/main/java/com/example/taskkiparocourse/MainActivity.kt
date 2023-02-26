package com.example.taskkiparocourse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskkiparocourse.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.jsonButton.setOnClickListener {
            val intent = Intent(this@MainActivity, NewsJSONActivity::class.java)
            this@MainActivity.startActivity(intent)
        }

//        binding.xmlButton.setOnClickListener {
//            val intent = Intent(this@MainActivity, NestedJSONActivity::class.java)
//            this@MainActivity.startActivity(intent)
//        }
    }
}