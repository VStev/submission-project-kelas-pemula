package com.example.submissionproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GameDetailActivity : AppCompatActivity() {
    private val games: ArrayList<Game> = arrayListOf()

    companion object {
        const val EXTRA_POSITION = "extra_position"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)
        setLayout()
    }

    fun setLayout(){
        val posterImg: ImageView = findViewById(R.id.game_poster)
        val gameTitle: TextView = findViewById(R.id.game_title)
        val gameMSRP: TextView = findViewById(R.id.game_msrp)
        val gamePrice: TextView = findViewById(R.id.current_price)
        val gameDev: TextView = findViewById(R.id.game_developer)
        val gameDesc: TextView = findViewById(R.id.game_description)
        val btnFavorite: Button = findViewById(R.id.button_favourite)
        val position = intent.getIntExtra(EXTRA_POSITION, 0)
        games.addAll(GameData.listData)
        val data = games[position]
        val text = "Developed by : ${data.developer}"
        Glide.with(this)
            .load(data.gamePoster)
            .into(posterImg)
        gameTitle.text = data.title
        gameMSRP.text = data.msrp
        gamePrice.text = data.currentPrice
        gameDev.text = text
        gameDesc.text = data.description
        btnFavorite.text = if (data.favStatus == 0) "Favorite" else "Unfavorite"
        btnFavorite.setOnClickListener{setFav(data)}
    }

    fun setFav(data: Game){
        if (data.favStatus == 0) Toast.makeText(this.applicationContext, "You've set ${data.title} as your favorite." , Toast.LENGTH_SHORT).show() else Toast.makeText(this.applicationContext, "You no longer set ${data.title} as your favorite." , Toast.LENGTH_SHORT).show()
        data.favStatus = if (data.favStatus == 0) 1 else 0
        setLayout()
    }
}