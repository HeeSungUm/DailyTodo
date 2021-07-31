package com.heesungum.dailytodo

import android.view.View
import androidx.databinding.BindingAdapter

object BindingUtils {
    private const val ON_LONG_CLICK = "android:onLongClick"

    @JvmStatic
    @BindingAdapter(ON_LONG_CLICK)
    fun setOnLingClickLister(
        view: View,
        func : () -> Unit
    ) {
        view.setOnLongClickListener {
            func()
            return@setOnLongClickListener true
        }
    }
}