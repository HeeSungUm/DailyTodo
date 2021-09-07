package com.heesungum.dailytodo

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.text.SimpleDateFormat
import java.util.*

class DateChangedReceiver: BroadcastReceiver() {
    private val _today: MutableLiveData<String> = MutableLiveData()
    val today: LiveData<String>
        get() = _today
    private val dateFormat = "yy/MM/dd"

    init {
        val calender: Calendar = Calendar.getInstance()
        var text = ""
        text = SimpleDateFormat(dateFormat, Locale.KOREA).format(calender.time)
        text = "$text 할 일"
        _today.value = text
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val repository = TodoRepository(context?.applicationContext as Application)
        val calender: Calendar = Calendar.getInstance()
        var text = ""

        suspend {
            repository.updateAllFalse()
        }

        text = SimpleDateFormat(dateFormat, Locale.KOREA).format(calender.time)
        text = "$text 할 일"
        _today.value = text

    }

}