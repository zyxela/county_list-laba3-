package com.example.lab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class RAdapter(val countryList: MutableList<String>, val iv:ImageView, val cil:List<String>) : RecyclerView.Adapter<RViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.r_item, parent, false)
        return RViewHolder(item, iv, cil)
    }

    override fun getItemCount(): Int {
        return countryList.count()
    }

    override fun onBindViewHolder(holder: RViewHolder, position: Int) {
        val tv = holder.itemView.findViewById<TextView>(R.id.countryName)
        tv.text = countryList[position]
        tv.setOnClickListener {
            val imageLink = cil[position]
            Picasso.get().load(imageLink).into(iv)
        }
    }
}

class RViewHolder(itemView: View, iv: ImageView, val cil:List<String>) : RecyclerView.ViewHolder(itemView)
{
    init{

    }
}