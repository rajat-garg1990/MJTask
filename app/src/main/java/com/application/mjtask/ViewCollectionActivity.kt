package com.application.mjtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class ViewCollectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_collection)

        var webView=findViewById<WebView>(R.id.webView)
        var url=intent.getStringExtra("link")
        webView.webViewClient= WebViewClient()
        webView.loadUrl(url!!)
    }
}