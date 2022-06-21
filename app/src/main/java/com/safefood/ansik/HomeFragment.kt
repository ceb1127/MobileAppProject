package com.safefood.ansik

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.google.firebase.auth.FirebaseAuth
import com.safefood.ansik.databinding.FragmentHomeBinding
import java.util.*


class HomeFragment: Fragment() {
    val binding by lazy { FragmentHomeBinding.inflate(layoutInflater)}
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home,container,false)

        binding.foodsearchBtn.setOnClickListener {
            val intent = Intent(activity, FoodlistActivity::class.java)
            startActivity(intent)
        }

        val toolbar : Toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)

        //preference id username설정
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        var username = sharedPreferences.getString("idSetting"," ")
        binding.username.setText("$username")

        /*
        //preference 배경 테마 설정
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val bgColor = sharedPreferences.getString("bgColorSetting","")
        binding.rootLayoutHome.setBackgroundColor(Color.parseColor(bgColor))
        */

        /*
        var filtertext =  sharedPreferences.getStringSet("allergySetting"," ")
        binding.allergyTextView.setText("$filtertext")
        */

        //로그아웃
        binding.logoutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(activity, Login::class.java)
            startActivity(intent)
        }

        return binding.root

    }



    override fun onResume() {
        super.onResume()

        /*
        val bgColor = sharedPreferences.getString("bgColorSetting","")
        binding.rootLayoutHome.setBackgroundColor(Color.parseColor(bgColor))
        */

    }



    }


