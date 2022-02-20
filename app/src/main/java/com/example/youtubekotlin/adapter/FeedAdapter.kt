package com.example.youtubekotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubekotlin.R
import com.example.youtubekotlin.model.Feed
import com.example.youtubekotlin.model.Member
import com.example.youtubekotlin.model.Story
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlin.coroutines.coroutineContext

class FeedAdapter(var context: Context, var items: ArrayList<Member>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ITEM_FEED = 1
    private val TYPE_ITEM_STORY = 0

    override fun getItemViewType(position: Int): Int {
        var feed = items[position]
        if (feed.storys.size > 0){
            return TYPE_ITEM_STORY
        }
        return TYPE_ITEM_FEED
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       if (viewType == TYPE_ITEM_STORY){
           val view =
               LayoutInflater.from(parent.context).inflate(R.layout.item_feed_recyc_view, parent, false)
           return RecycViewHolder(view,context)
       }
       return FeedViewHolder(context, LayoutInflater.from(parent.context).inflate(R.layout.item_feed_view, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = items[position]

        if (holder is RecycViewHolder){
            var recyclerView = holder.recyclerView
            refreshAdapter(item.storys, recyclerView)
        }
        if (holder is FeedViewHolder){
            var vv_feed_vedio = holder.vv_feed_vedio
            var iv_feed_profile = holder.iv_feed_profile
            var tv_feed_name = holder.tv_feed_name
            var tv_feed_about = holder.tv_feed_about

            vv_feed_vedio.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = item.feed!!.vv_feed_vedio
                    youTubePlayer.loadVideo(videoId, 0f)
                }
            })
            iv_feed_profile.setImageResource(item.feed!!.iv_feed_profile)
            tv_feed_name.text = item.feed!!.tv_feed_name
            tv_feed_about.text = item.feed!!.tv_feed_about
        }
    }

    private fun refreshAdapter(items: ArrayList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context, items)

        recyclerView!!.adapter = adapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RecycViewHolder(view: View,var context: Context) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView
        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            val story = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.layoutManager = story
        }
    }


    class FeedViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var vv_feed_vedio: YouTubePlayerView
        var iv_feed_profile: ImageView
        var tv_feed_name: TextView
        var tv_feed_about: TextView

        init {
            vv_feed_vedio = view.findViewById(R.id.vv_feed_vedio)
            iv_feed_profile = view.findViewById(R.id.iv_feed_profile)
            tv_feed_name = view.findViewById(R.id.tv_video_name)
            tv_feed_about = view.findViewById(R.id.tv_video_about)
        }
    }

}