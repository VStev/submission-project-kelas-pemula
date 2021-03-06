package com.example.submissionproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GameDataAdapter (private val gameList: ArrayList<Game>): RecyclerView.Adapter<GameDataAdapter.GameDataHolder>() {
    inner class GameDataHolder (items: View): RecyclerView.ViewHolder(items) {
        val gameTitle: TextView =items.findViewById(R.id.game_title)
        val gameDesc: TextView = items.findViewById(R.id.game_desc)
        val gamePrice: TextView = items.findViewById(R.id.current_price)
        val gamePic: ImageView = items.findViewById(R.id.product_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameDataHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return GameDataHolder(view)
    }

    override fun onBindViewHolder(holder: GameDataHolder, position: Int) {
        val game = gameList[position]
        Glide.with(holder.itemView.context)
                .load(game.gameCover)
                .apply(RequestOptions().override(350, 550))
                .into(holder.gamePic)
        holder.gameTitle.text = game.title
        holder.gameDesc.text = game.description
        holder.gamePrice.text = game.currentPrice
    }

    override fun getItemCount(): Int = gameList.size

}