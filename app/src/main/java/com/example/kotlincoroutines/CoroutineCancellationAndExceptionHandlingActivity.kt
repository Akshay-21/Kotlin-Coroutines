package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//In-Depth Guide to Coroutine Cancellation & Exception Handling

class CoroutineCancellationAndExceptionHandlingActivity : AppCompatActivity() {

    private val TAG = "CoroutineCancellationAndExceptionHandlingActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_cancellation_and_exception_handling)

//        lifecycleScope.launch {
//        lifecycleScope.async {
        val deferred = lifecycleScope.async {

            /*    try {
                    launch {// Child coroutines
                        throw Exception()
                    }
                } catch (ex: Exception) {
                    println("Caught exception: $ex")
                }*/


//            This is not good approach to handling exception.

            val string = async {
                delay(500L)
                throw Exception("Error")
                "Result"
            }
            println(string.await())
        }

        lifecycleScope.launch {
            deferred.await()
        }
    }
}