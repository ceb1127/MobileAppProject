package com.safefood.ansik

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.safefood.ansik.databinding.ActivityFoodlistBinding
import com.safefood.ansik.databinding.ItemFoodlistBinding


class MyViewHolder(val binding: ItemFoodlistBinding):RecyclerView.ViewHolder(binding.root)
class FoodItemAdapter(val context: Context, val datas:MutableList<FoodItemModel>?): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun getItemCount(): Int {
        return datas?.size ?:0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemFoodlistBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        val model = datas!![position]
        binding.foodName.text = model.prdlstNm
        binding.allergy.text = model.allergy
        Glide.with(binding.root)
            .load(model.imgurl1)
            .into(binding.foodImage)
    }

}


