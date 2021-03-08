package com.example.submissionproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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
        supportActionBar?.title = "Deku Deals"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menubar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val about = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(about)
        return super.onOptionsItemSelected(item)
    }

    private fun showLayout(){
        recycleview.layoutManager = LinearLayoutManager(this)
        val dataAdapter = GameDataAdapter(list)
        recycleview.adapter = dataAdapter

        dataAdapter.setOnItemClickCallback(object: GameDataAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Int) {
                val moveIntent = Intent(this@MainActivity, GameDetailActivity::class.java)
                moveIntent.putExtra(GameDetailActivity.EXTRA_POSITION, data)
                startActivity(moveIntent)
            }
        })
    }
}