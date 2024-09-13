package com.example.kotlincoroutines


import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface MyAPI {
    @GET("/comments")
//   fun getComment(): Call<List<Comment>>
   suspend fun getComment(): Response<List<Comment>>
}