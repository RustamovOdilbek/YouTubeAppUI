package com.example.youtubekotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubekotlin.R
import com.example.youtubekotlin.model.Filter

class FilterAdapter(var context: Context, var items: ArrayList<Filter>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var TYPE_ITEM_ONE = 1
    var TYPE_ITEM_OTHER = 0

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return TYPE_ITEM_ONE
        return TYPE_ITEM_OTHER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ONE){
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_explore_view, parent, false)
            return ExploreViewHolder(view)
        }
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_filter_view, parent, false)
        return FilterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = items[position]
        if (holder is ExploreViewHolder){

        }
        if (holder is FilterViewHolder){
            var title = holder.title

            title.text = item.tv_title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ExploreViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    class FilterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView

        init {
            title = view.findViewById(R.id.tv_title)
        }
    }
}