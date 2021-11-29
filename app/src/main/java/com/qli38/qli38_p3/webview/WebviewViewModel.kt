package com.qli38.qli38_p3.webview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.qli38.qli38_p3.WebViewClassApp.Companion.DEFAULT_URL

class WebviewViewModel : ViewModel() {

    private val _url = MutableLiveData<String>().apply {
        value = DEFAULT_URL
    }
    val url: LiveData<String> = _url
    fun setUrl(url: String) {
        _url.value = url
    }
}