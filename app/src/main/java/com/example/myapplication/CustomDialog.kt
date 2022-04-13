package com.example.myapplication

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import kotlinx.android.synthetic.main.dialog.*;

class CustomDialog(context: Context)
{
    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun showDialog1()
    {
        dialog.setContentView(R.layout.dialog)
        // 다이얼로그 크기 설정
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        // 취소 버튼
        dialog.dialog_cancel.setOnClickListener {
            dialog.dismiss()
        }

        // 확인 버튼
        dialog.dialog_confirm.setOnClickListener {
            dialog.dismiss()
        }

    }

    fun showDialog2()
    {
        dialog.setContentView(R.layout.dialog)
        // 알림창 문구 변경
        dialog.dialog_desc.setText(R.string.pwd_error_diff)
        // 다이얼로그 크기 설정
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        // 취소 버튼
        dialog.dialog_cancel.setOnClickListener {
            dialog.dismiss()
        }

        // 확인 버튼
        dialog.dialog_confirm.setOnClickListener {
            dialog.dismiss()
        }
    }

    fun showDialog3()
    {
        dialog.setContentView(R.layout.dialog)
        // 알림창 문구 변경
        dialog.dialog_desc.setText(R.string.pwd_error_null)
        // 다이얼로그 크기 설정
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        // 취소 버튼
        dialog.dialog_cancel.setOnClickListener {
            dialog.dismiss()
        }

        // 확인 버튼
        dialog.dialog_confirm.setOnClickListener {
            dialog.dismiss()
        }
    }
    interface OnDialogClickListener
    {
        fun onClicked(name: String)
    }

}