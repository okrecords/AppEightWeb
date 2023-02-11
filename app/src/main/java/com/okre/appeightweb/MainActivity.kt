package com.okre.appeightweb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*------------------------------------------------------------------------------------------
        * 로그아웃 버튼
        ------------------------------------------------------------------------------------------*/
        val logoutBtn = findViewById<TextView>(R.id.logoutBtn)
        logoutBtn.setOnClickListener {
            Firebase.auth.signOut()
            Toast.makeText(this, "로그아웃 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
            finish()
        }

        /*------------------------------------------------------------------------------------------
        * 북마크 버튼
        ------------------------------------------------------------------------------------------*/
        val bookmarkBtn = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkBtn.setOnClickListener {
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        /*------------------------------------------------------------------------------------------
        * RecyclerView 데이터 생성
        ------------------------------------------------------------------------------------------*/
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/aeO_cG35KO",
            "https://mp-seoul-image-production-s3.mangoplate.com/1946053_1641819698689402.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
             "패스트리부티크"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/q-ImZ-DGRhlY",
                "https://mp-seoul-image-production-s3.mangoplate.com/259634_1509715429202580.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "소울브레드"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/dElK7hRQymUE",
                "https://mp-seoul-image-production-s3.mangoplate.com/395612/1042666_1643860562441_43101?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "쇼토"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/dElK7hRQymUE",
                "https://mp-seoul-image-production-s3.mangoplate.com/395612/1042666_1643860562441_43101?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "쇼토"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/6GA7iexxTg",
                "https://mp-seoul-image-production-s3.mangoplate.com/192534/172778_1571234079238_115364?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "메종엠오"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/aeO_cG35KO",
                "https://mp-seoul-image-production-s3.mangoplate.com/1946053_1641819698689402.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "패스트리부티크"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/q-ImZ-DGRhlY",
                "https://mp-seoul-image-production-s3.mangoplate.com/259634_1509715429202580.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "소울브레드"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/dElK7hRQymUE",
                "https://mp-seoul-image-production-s3.mangoplate.com/395612/1042666_1643860562441_43101?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "쇼토"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/dElK7hRQymUE",
                "https://mp-seoul-image-production-s3.mangoplate.com/395612/1042666_1643860562441_43101?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "쇼토"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/6GA7iexxTg",
                "https://mp-seoul-image-production-s3.mangoplate.com/192534/172778_1571234079238_115364?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "메종엠오"
            )
        )

        /*------------------------------------------------------------------------------------------
        * RecyclerView 어댑터 연결
        ------------------------------------------------------------------------------------------*/
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, items) //glide context 전달
        recyclerView.adapter =rvAdapter

        //recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)

                intent.putExtra("url", items[position].url)
                intent.putExtra("titleText", items[position].titleText)
                intent.putExtra("imageUrl", items[position].imageUrl)

                startActivity(intent)
            }
        }
    }
}