package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val preferenceFragment = PreferenceFragment()
        val bookmarkFragment = BookmarkFragment()
        val settingFragment = SettingFragment()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        replaceFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.tab1 -> replaceFragment(homeFragment)
                R.id.tab2 -> replaceFragment(preferenceFragment)
                R.id.tab3 -> replaceFragment(bookmarkFragment)
                R.id.tab4 -> replaceFragment(settingFragment)
            }
            true
        }

        /*
                // 트리거 워닝 페이지로 이동
        to_trigger.setOnClickListener{
            val intent = Intent(this, SubActivityTrigger::class.java)
            startActivity(intent)
        }

        // 비밀번호 재설정 페이지로 이동
        to_password.setOnClickListener{
            val intent = Intent(this, SubActivityPassword::class.java)
            startActivity(intent)
        }
        */
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }
}


