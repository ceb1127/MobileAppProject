package com.example.noggro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.view.Menu
import android.view.View
import android.widget.Adapter
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.noggro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var rv : RecyclerView
    private lateinit var RecentItemAdapter : Adapter
    private lateinit var favoriteItemAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = Home()
        fragmentTransaction.add(R.id.fragment, fragment)
        fragmentTransaction.commit()








    }


}