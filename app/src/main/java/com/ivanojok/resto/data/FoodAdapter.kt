package com.ivanojok.resto.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ivanojok.resto.R

class FoodAdapter(val context:Context, val list:ArrayList<FoodModel>): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.imageView)
        val name = itemView.findViewById<TextView>(R.id.food_name)
        val price = itemView.findViewById<TextView>(R.id.food_price)
        val description = itemView.findViewById<TextView>(R.id.food_description)
        val card = itemView.findViewById<CardView>(R.id.food_card)
        val foodLayout = itemView.findViewById<ConstraintLayout>(R.id.description_layout)
        val delete = itemView.findViewById<ImageView>(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_layout, parent, false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.price.text = list[position].price
        holder.description.text = list[position].description
        holder.card.setOnClickListener {
            if (holder.foodLayout.visibility == View.VISIBLE) {
                holder.foodLayout.visibility = View.GONE
            } else {
                holder.foodLayout.visibility = View.VISIBLE
            }
        }

        holder.delete.setOnClickListener {
            list.removeAt(position)
            notifyDataSetChanged()
            notifyItemRemoved(position)
        }

        holder.image.setImageResource(R.drawable.chicken)

    }
}

//DiffUtils