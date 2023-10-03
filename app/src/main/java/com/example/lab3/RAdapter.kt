package com.example.lab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class RAdapter(val countryList: MutableList<String>, val iv:ImageView) : RecyclerView.Adapter<RViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.r_item, parent, false)
        return RViewHolder(item, iv)
    }

    override fun getItemCount(): Int {
        return countryList.count()
    }

    override fun onBindViewHolder(holder: RViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.countryName).text = countryList[position]
    }
}

class RViewHolder(itemView: View, iv: ImageView) : RecyclerView.ViewHolder(itemView)
{
    init{
        itemView.setOnClickListener {
            Picasso.get().load("https://img.freeflagicons.com/preview/australia.png").into(iv)
        }
    }
}