package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

//In-Depth Guide to Coroutine Cancellation & Exception Handling

class CoroutineCancellationAndExceptionHandlingActivity : AppCompatActivity() {

    private val TAG = "CoroutineCancellationAndExceptionHandlingActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_cancellation_and_exception_handling)

        lifecycleScope.launch {
            val job = launch {

                try {
                    delay(500L)
                } catch (ex: Exception) {
                    if(ex is CancellationException){
                        throw ex
                    }
                    ex.printStackTrace()
                }
                println("Coroutines 1 finished")
            }
            delay(300L)
            job.cancel()
        }


        /*
        //        CoroutineExceptionHandler with custom Coroutines and also using supervisorScope
                val handler1 = CoroutineExceptionHandler { _, thorable ->
                    println("Caught exception $thorable")
                }

                CoroutineScope(Dispatchers.Main + handler1).launch {
                    supervisorScope {
        //                In this scope if any coroutines failed, throws exception or cancelled it would not affect other coroutines.
                        launch { // Child Coroutines
                            delay(300L)
                            throw Exception("Coroutine 1 failed")
                        }

                        launch {
                            delay(400L)
                            throw Exception("Coroutines 2 finished")
                        }
                    }
                }
                */

        /*
        //        Coroutine Cancellation & Exception Handling - on Cancellation coroutines
                val handler = CoroutineExceptionHandler { _, throwable ->
                    println("caught exception: $throwable")
                }


                lifecycleScope.launch(handler) {
        //            throw Exception("Error")

                    launch {
                        throw Exception("Error")
                    }
                }
        */


//        lifecycleScope.launch {
//        lifecycleScope.async {
        /*
        val deferred = lifecycleScope.async {

            *//*    try {
                    launch {// Child coroutines
                        throw Exception()
                    }
                } catch (ex: Exception) {
                    println("Caught exception: $ex")
                }

                */

        /*
//            This is not good approach to handling exception.

            val string = async {
                delay(500L)
                throw Exception("Error")
                "Result"
            }
            println(string.await())
        }*/

        /*        lifecycleScope.launch {
                    try {
                        deferred.await()
                    }catch (ex:Exception){
                        ex.printStackTrace()
                    }
                }*/
    }
}