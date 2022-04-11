package com.example.myapplication

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.dialog.*
import kotlinx.android.synthetic.main.setting_password_change.*

class SubActivityPassword : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_password_change)

        // 뒤로가기 버튼
        btn_goback.setOnClickListener{
            finish()
        }

        // 비밀번호 재설정
        password_confirm.setOnClickListener{

            var dialog = CustomDialog(this)  // 다이얼로그 생성

            // 빈칸이 있는 경우
            if(password_orig_edit.text.toString()=="" || password_new_edit.text.toString()==""
                || password_new_confirm_edit.text.toString()==""){
                // 알림 메시지
                dialog.showDialog3()
                //finish()
            }
            else{
                /**** 사용자 정보와 비교 - db에 저장된 비밀번호와 입력받은 '기존 비밀번호' 비교
                 * 일단 나중에...*****/

                // 기존 비밀번호와 새 비밀번호가 같은 경우
                if(password_orig_edit.text.toString() == password_new_edit.text.toString()){
                    dialog.showDialog1()  // 다이얼로그 띄우기
                }
                // 새 비밀번호와 비밀번호 확인이 다른 경우
                if(password_new_edit.text.toString() !=(password_new_confirm_edit.text.toString())){
                    dialog.showDialog2()
                }
            }

        }
    }
}