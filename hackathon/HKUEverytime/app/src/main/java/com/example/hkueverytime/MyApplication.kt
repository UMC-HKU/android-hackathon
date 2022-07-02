package com.example.hkueverytime

import android.app.Application
import android.os.Build
import android.text.format.DateFormat
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object{

        fun formatTimeStamp(timestamp: Long) : String{
            val cal = System.currentTimeMillis()
            val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm")
            val date = sdf.format(timestamp)
            return date.toString()
        }

    }
}