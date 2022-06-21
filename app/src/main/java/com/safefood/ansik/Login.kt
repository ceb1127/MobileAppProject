package com.safefood.ansik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.util.SdkLog.Companion.instance
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.common.util.Utility
import com.safefood.ansik.databinding.ActivityLoginBinding


class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var auth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val signUpPage = binding.signUpPage
        val loginButton = binding.loginButton

        val loginId = binding.loginId
        val loginPassword = binding.loginPassword


        // 회원가입 창으로
        signUpPage.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
        }

        // 로그인 버튼
        loginButton.setOnClickListener {
            signIn(loginId.text.toString(), loginPassword.text.toString())
        }


        //카카오
        binding.btnKakaoLogin.setOnClickListener{
        // 토큰 정보 보기
            UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
                if (error != null) {
                    Log.e("mobileApp", "토큰 정보 보기 실패", error)
                }
                else if (tokenInfo != null) {
                    Log.i("mobileApp", "토큰 정보 보기 성공")
                    finish()
                }
            }
            // 카카오계정으로 로그인 공통 callback 구성
            // 카카오톡으로 로그인 할 수 없어 카카오계정으로 로그인할 경우 사용됨
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    Log.e("mobileApp", "카카오계정으로 로그인 실패", error)
                } else if (token != null) {
                    Log.i("mobileApp", "카카오계정으로 로그인 성공 ${token.accessToken}")
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()

                    // 사용자 정보 요청 (기본)
                    UserApiClient.instance.me { user, error ->
                        if (error != null) {
                            Log.e("mobileApp", "사용자 정보 요청 실패", error)
                        }
                        else if (user != null) {
                            Log.i("mobileApp", "사용자 정보 요청 성공 ${user.kakaoAccount?.email} ${user.kakaoAccount?.profile?.nickname}")
                            var scopes = mutableListOf<String>()
                            if(user.kakaoAccount?.email != null){
                                //MyApplication.email = user.kakaoAccount?.email
                                finish()
                            }else if (user.kakaoAccount?.emailNeedsAgreement == true){
                                Log.i("mobileApp", "사용자에게 추가 동의 필요")
                                scopes.add("account_email")
                                scopes.add("profile_nickname")
                                UserApiClient.instance.loginWithNewScopes(this,scopes){ token, error ->
                                    if(error != null){
                                        Log.e("mobileApp", "추가 동의 실패", error)
                                    } else{
                                        //사용자 정보 재요청
                                        UserApiClient.instance.me { user, error ->
                                            if(error != null){
                                                Log.e("mobileApp", "사용자 정보 요청 실패", error)
                                            }
                                            else if(user != null){
                                                //MyApplication.email = user.kakaoAccount?.email.toSting()
                                                finish()
                                            }

                                        }
                                    }
                                }
                            }
                            else{
                                Log.e("mobileApp", "이메일 획득 불가", error)
                            }

                        }
                    }


                }
            }
            if(UserApiClient.instance.isKakaoTalkLoginAvailable(this)){
                UserApiClient.instance.loginWithKakaoTalk(this,callback = callback)
            }
            else{
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }

        }







    }
        /*
        // 로그아웃하지 않을 시 자동 로그인 , 회원가입시 바로 로그인 됨
        public override fun onStart() {
            super.onStart()
            moveMainPage(auth?.currentUser)
        }
         */



        // 로그인
        private fun signIn(email: String, password: String) {

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth?.signInWithEmailAndPassword(email, password)
                    ?.addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                baseContext, "로그인에 성공 하였습니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                            moveMainPage(auth?.currentUser)
                        } else {
                            Toast.makeText(
                                baseContext, "로그인에 실패 하였습니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }


    // 유저정보 넘겨주고 메인 액티비티 호출
    fun moveMainPage(user: FirebaseUser?) {
        if (user != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}



