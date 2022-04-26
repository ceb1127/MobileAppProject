package com.example.noggro


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecentItemAdapter(private val items: ArrayList<recentItemData> ) : RecyclerView.Adapter<RecentItemAdapter.ViewHolder>() {


    //보여줄 아이템 개수가 몇개인지 알려줌
    override fun getItemCount(): Int = items.size

    //생성된 view에 보여줄 데이터를 설정
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
    }

    //보여줄 아이템 개수만큼 view를 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recent,parent,false)
        return RecentItemAdapter.ViewHolder(view)
    }

    //viewHolder 단위 객체로 view 의 데이터를 설정
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}