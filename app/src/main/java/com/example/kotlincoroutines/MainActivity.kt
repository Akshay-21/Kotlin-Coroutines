package com.example.kotlincoroutines

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv)


//        Global Scope

        /*
                GlobalScope.launch {
        //            delay(3000L) // Delay/Sleep Thread for 3 second.
        //            If one coroutines pauses/delay it would not affect other coroutines. other thread will just keep working. (If coroutines are pause/delayed which would equivalent Thread.sleep().
        //            Note: if main thread finishes with his work then that means all other thread and coroutines will be cancelled so even though they are started  in an another thread and are executed asynchronously the will be cancelled if the main thread finishes his work.
        //            we can see that if we increase the delay to 5 second from 3 second.
                    delay(5000L)
        //            if we quit the app other thread and coroutines will be cancelled.
                    Log.d(TAG, "onCreate: Coroutines say hello from thread ${Thread.currentThread().name} ")
                }
                Log.d(TAG, "onCreate: hello from thread ${Thread.currentThread().name} ")
        */


        //        Suspend Functions

        /*        GlobalScope.launch {
                    val networkCallAnswer1 = doNetworkCall()
                    val networkCallAnswer2 = doNetworkCall2()
                    Log.d(TAG, networkCallAnswer1)
                    Log.d(TAG, networkCallAnswer2)
                }*/

        /**
         *  The result will print after 6 second because the first delay call influence second delay call because both
         *  executing in same coroutines.
         * */


        //  Coroutine Contexts - Kotlin Coroutines
        /*GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG, "Starting coroutines in thread ${Thread.currentThread().name}")
            val answer = doNetworkCall()
            withContext(Dispatchers.Main) {
                Log.d(TAG, "Setting text in thread thread ${Thread.currentThread().name}")
                tv.text = answer
            }
        }*/

//  runBlocking - Kotlin Coroutines

        /*        Log.d(TAG, "Before run blocking")
                runBlocking {
                    launch {
                        delay(3000L)
                        Log.d(TAG, "Finish IO Coroutines 1")
                    }
                    launch {
                        delay(3000L)
                        Log.d(TAG, "Finish IO Coroutines 2")
                    }
                    Log.d(TAG, "Start run blocking")
                    delay(5000L)
                    Log.d(TAG, "End run blocking")
                }*/

        /* Log.d(TAG, "Start run blocking")
         Thread.sleep(5000L)
         Log.d(TAG, "End run blocking")*/

//        Log.d(TAG, "After run blocking")

        /**
         * Here delay() and Thread.sleep() block the main/ui thread (will work for same).
         */


//        Jobs, Waiting, Cancelation - Kotlin Coroutines

        val job = GlobalScope.launch(Dispatchers.Default) {
            /* repeat(5) {
                 Log.d(TAG, "Coroutines is still working...")
                 delay(1000L)
             }*/


//           Coroutines Job Cancellation
            Log.d(TAG, "Starting long running calculation...")
            withTimeout(3000L){
                for (i in 30..50) {
                    if (isActive){
                        Log.d(TAG, "Result for i = $i : ${fib(i)}")
                    }
                }
            }

            Log.d(TAG, "Ending long running calculation...")
        }

/*        runBlocking {
//            job.join()  // job coroutines join to execute.

            *//*delay(2000L)
            job.cancel()
            Log.d(TAG, "Main Thread is continuing...")*//*

//           Coroutines Job Cancellation
            delay(2000L)
            job.cancel()
            Log.d(TAG, "Canceled Job!")
        }*/

    }

    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "THis is the answer1"
    }

    suspend fun doNetworkCall2(): String {
        delay(3000L)
        return "THis is the answer2"
    }

    private fun fib(n: Int): Long {
        return if (n == 0) 0
        else if (n == 1) 1
        else fib(n - 1) + fib(n - 2)
    }
}