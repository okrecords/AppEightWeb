package com.okre.appeightweb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val contents = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        auth = Firebase.auth

        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref")

        /*------------------------------------------------------------------------------------------
        * RecyclerView 어댑터 연결
        ------------------------------------------------------------------------------------------*/
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, contents)
        recyclerView.adapter =rvAdapter

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)

                intent.putExtra("url", contents[position].url)
                intent.putExtra("titleText", contents[position].titleText)
                intent.putExtra("imageUrl", contents[position].imageUrl)

                startActivity(intent)
            }
        }

        /*------------------------------------------------------------------------------------------
        * 북마크 리스트 불러오기
        ------------------------------------------------------------------------------------------*/
        myBookmarkRef
            .child(auth.currentUser?.uid.toString())
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    for (dataModel in snapshot.children) {
                        contents.add(dataModel.getValue(ContentsModel::class.java)!!)
                    }
                    rvAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("Bookmark", "dbError")
                }
            })
    }
}