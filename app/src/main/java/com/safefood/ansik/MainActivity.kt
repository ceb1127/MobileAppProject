package com.safefood.ansik

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.safefood.ansik.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kakao.sdk.common.util.Utility
import retrofit2.Call


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //해시키 구하기
        //val keyHash = Utility.getKeyHash(this)
        //Log.d("hash", keyHash)

        val homeFragment = HomeFragment()
        val mapFragment = MapFragment()
        val settingFragment = SettingFragment()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        replaceFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.tab1 -> replaceFragment(homeFragment)
                R.id.tab2 -> replaceFragment(mapFragment)
                R.id.tab3 -> replaceFragment(settingFragment)
            }
            true
        }

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer,HomeFragment()).commit()




    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment).commit()

    }
}


