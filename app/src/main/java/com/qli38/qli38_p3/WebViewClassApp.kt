package com.qli38.qli38_p3

import android.app.Application

class WebViewClassApp : Application() {

    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    companion object {
        private lateinit var instance: WebViewClassApp
        const val DEFAULT_URL = "https://mitchalbala.com/getting-the-light-right-the-power-of-the-color-study/"
    }
}