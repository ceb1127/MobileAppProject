package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_bookmark.view.*
import java.util.ArrayList

class BookmarkItemAdapter: RecyclerView.Adapter<BookmarkItemAdapter.ViewHolder>() {
    var items = ArrayList<BookmarkItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkItemAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_bookmark, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookmarkItemAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(item: BookmarkItemData){
            itemView.textview1.text = item.title
        }
    }
}