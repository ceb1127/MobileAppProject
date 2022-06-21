package com.safefood.ansik

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this,"8e1af695580d7576b0d68c2854a9ceb1")
    }
}