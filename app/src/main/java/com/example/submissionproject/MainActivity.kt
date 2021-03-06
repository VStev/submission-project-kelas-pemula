package com.example.submissionproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recycleview: RecyclerView
    private var list: ArrayList<Game> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleview = findViewById(R.id.product_list)
        recycleview.setHasFixedSize(true)
        list.addAll(GameData.listData)
        showLayout()
    }

    private fun showLayout(){
        recycleview.layoutManager = LinearLayoutManager(this)
        recycleview.adapter = GameDataAdapter(list)
    }
}