package com.heesungum.dailytodo

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.heesungum.dailytodo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var dateChangedReceiver: DateChangedReceiver

    private val fragmentHome by lazy { HomeFragment() }

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    private lateinit var todoViewModel: TodoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        dateChangedReceiver = DateChangedReceiver()

        binding.mainBottomNavigation.run {
            this.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.page_home -> {
                        changeFragment(fragmentHome)
                    }
                }
                true
            }
            selectedItemId = R.id.page_home
        }

    }

    override fun onStart() {
        super.onStart()
        todoViewModel.setToday(dateChangedReceiver.today)
        registerReceiver(dateChangedReceiver, IntentFilter(Intent.ACTION_TIME_CHANGED))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(dateChangedReceiver)
    }


    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }


    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}

