package com.heesungum.dailytodo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import java.text.SimpleDateFormat
import java.util.*

class DateChangedReceiver: BroadcastReceiver() {
    private val today: MutableLiveData<String> = MutableLiveData()

    override fun onReceive(context: Context?, intent: Intent?) {
        val calender: Calendar = Calendar.getInstance()
        val dateFormat = "yyyy/mm/dd"
        today.value = SimpleDateFormat(dateFormat, Locale.KOREA).format(calender.time)
    }
    fun getToday(): MutableLiveData<String>{
        val calender: Calendar = Calendar.getInstance()
        val dateFormat = "yyyy/mm/dd"
        today.value = SimpleDateFormat(dateFormat, Locale.KOREA).format(calender.time)
        return today
    }

}