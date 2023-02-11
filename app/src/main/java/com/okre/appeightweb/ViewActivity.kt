package com.okre.appeightweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        auth = Firebase.auth

        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref")

        /*------------------------------------------------------------------------------------------
        * WebView
        ------------------------------------------------------------------------------------------*/
        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl(intent.getStringExtra("url").toString())

        val url = intent.getStringExtra("url").toString()
        val titleText = intent.getStringExtra("titleText").toString()
        val imageUrl = intent.getStringExtra("imageUrl").toString()

        /*------------------------------------------------------------------------------------------
        * 북마크에 저장하기
        ------------------------------------------------------------------------------------------*/
        val save = findViewById<TextView>(R.id.saveText)
        save.setOnClickListener {
            myBookmarkRef
                .child(auth.currentUser!!.uid)
                .push()
                .setValue(ContentsModel(url, imageUrl, titleText))
            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()
        }

    }
}