package com.example.activity31

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_food.view.*

class FoodAdapter(val foodList : MutableList<Food>): RecyclerView.Adapter<CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.row_food, parent, false)
        return CustomViewHolder(cellForRow)
    }
    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int){
        val food = foodList.get(position)
        holder.view.tvRowName.text = food.name
        holder.view.tvRowPrice.text = food.price.toString()
        holder.food = food
    }

}

class CustomViewHolder(val view : View, var food : Food? = null) : RecyclerView.ViewHolder(view){
    init {
        view.setOnClickListener {
            Toast.makeText(this.view.context,food?.description,Toast.LENGTH_LONG).show()
        }
    }
}