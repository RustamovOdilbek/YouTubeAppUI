package com.example.youtubekotlin.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.youtubekotlin.R
import com.example.youtubekotlin.model.Story
import com.example.youtubekotlin.MainActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import java.io.File
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer

import androidx.annotation.NonNull

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener





class StoryAdapter(var context: Context, var items: ArrayList<Story>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_view, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = items[position]

        if (holder is StoryViewHolder){
            var vv_story_view = holder.vv_story_view
            var tv_story_name = holder.tv_story_name
            var tv_story_view = holder.tv_story_view

            vv_story_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = item.vv_story_view
                    youTubePlayer.loadVideo(videoId, 0f)
                }
            })
            tv_story_name.text = item.tv_story_name
            tv_story_view.text = item.tv_story_view
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var vv_story_view: YouTubePlayerView
        var tv_story_name: TextView
        var tv_story_view: TextView

        init {
            vv_story_view = view.findViewById(R.id.vv_story_view)
            tv_story_name = view.findViewById(R.id.tv_story_name)
            tv_story_view = view.findViewById(R.id.tv_story_view)
        }
    }
}
