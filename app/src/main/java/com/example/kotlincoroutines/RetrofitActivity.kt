package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class RetrofitActivity : AppCompatActivity() {

    private val TAG: String = "RetrofitActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)


        val api =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAPI::class.java)

        GlobalScope.launch(Dispatchers.IO) {
//            val comments = api.getComment().await()
//            val response = api.getComment().awaitResponse()

            val response = api.getComment()
            if (response.isSuccessful) {
                for (comment in response.body()!!) {
                    Log.d(TAG, comment.toString())
                }
            }
        }
    }
}