package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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



        GlobalScope.launch {
            val networkCallAnswer1 = doNetworkCall()
            val networkCallAnswer2 = doNetworkCall2()
            Log.d(TAG, networkCallAnswer1)
            Log.d(TAG, networkCallAnswer2)
            /*
            *  The result will print after 6 second because the first delay call influence second delay call because both
            *  executing in same coroutines.
            *
            * */
        }
    }

    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "THis is the answer1"
    }

    suspend fun doNetworkCall2(): String {
        delay(3000L)
        return "THis is the answer2"
    }
}