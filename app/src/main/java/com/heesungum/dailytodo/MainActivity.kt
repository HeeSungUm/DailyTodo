package com.heesungum.dailytodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.heesungum.dailytodo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val fragmentHome by lazy { HomeFragment() }

    private var mBinding: ActivityMainBinding? = null

    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainBottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.page_home -> {
                    changeFragment(fragmentHome)
                }
            }
            true
        }


    }

    private fun changeFragment(fragment: Fragment){
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