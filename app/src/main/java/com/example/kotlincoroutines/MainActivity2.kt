package com.example.kotlincoroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        findViewById<AppCompatButton>(R.id.btnStartUserActivity).setOnClickListener {
            Intent(this@MainActivity2, UserActivity::class.java).also {
                startActivity(it)
            }
        }


        findViewById<AppCompatButton>(R.id.btnStartRetrofitActivity).setOnClickListener {
            Intent(this@MainActivity2, RetrofitActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}