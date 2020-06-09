package com.vickikbt.comix.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vickikbt.comix.R
import com.vickikbt.comix.data.model.Characters

class RecyclerviewAdapter(private val context: Context, private val characters: Characters) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rating =
            (characters[position].powerstats.combat + characters[position].powerstats.intelligence + characters[position].powerstats.durability + characters[position].powerstats.power+characters[position].powerstats.speed+characters[position].powerstats.strength)/6

        Glide.with(context).load(characters[position].images.md).into(holder.ivCharacter)
        holder.tvName.text = characters[position].name
//        holder.tvAliase.text = characters[position].biography.fullName.toString()
        holder.tvRating.text = "Rating: $rating"

    }


}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivCharacter: ImageView = itemView.findViewById(R.id.imageView_character)
//    val tvAliase = itemView.findViewById<TextView>(R.id.textView_name)
    val tvName: TextView = itemView.findViewById(R.id.textView_aliase)
    val tvRating: TextView = itemView.findViewById(R.id.textView_rating)

}

