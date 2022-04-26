package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.setting_trigger_main.*

class SubActivityTrigger : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.setting_trigger_main)

        // 뒤로가기 버튼
        btn_goback.setOnClickListener {
            finish()
        }

        // 추가하기 버튼
        btn_add.setOnClickListener {
            val intent = Intent(this, SubActivityTrigger_add::class.java)
            startActivity(intent)
        }
    }
}