package com.example.youtubekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubekotlin.adapter.FeedAdapter
import com.example.youtubekotlin.adapter.FilterAdapter
import com.example.youtubekotlin.model.Feed
import com.example.youtubekotlin.model.Filter
import com.example.youtubekotlin.model.Member
import com.example.youtubekotlin.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerFilter: RecyclerView
    lateinit var recyclerFeed: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }
    fun initViews(){
        recyclerFilter = findViewById(R.id.recyclerFilter)
        recyclerFilter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFeed.layoutManager = GridLayoutManager(this, 1)

        refreshFilterAdapter(getAllFilter())
        refreshFeedAdapter(getAllFeed())
    }

    private fun refreshFeedAdapter(items: ArrayList<Member>) {
        var adapter = FeedAdapter(this, items)
        recyclerFeed.adapter = adapter
    }

    private fun getAllFeed(): ArrayList<Member> {

        val stories: ArrayList<Story> = ArrayList()
        stories.add(Story("Ashorts/AV41BDMN_8M?feature", "2D emas 3D fikirlang  Alisher  Isaev", "523 ming marta"))
        stories.add(Story("AV41BDMN_8M?feature=share", "2D emas 3D fikirlang  Alisher  Isaev", "523 ming marta"))
        stories.add(Story("AV41BDMN_8M?feature=share", "2D emas 3D fikirlang  Alisher  Isaev", "523 ming marta"))
        stories.add(Story("AV41BDMN_8M?feature=share", "2D emas 3D fikirlang  Alisher  Isaev", "523 ming marta"))
        stories.add(Story("AV41BDMN_8M?feature=share", "2D emas 3D fikirlang  Alisher  Isaev", "523 ming marta"))
        stories.add(Story("AV41BDMN_8M?feature=share", "2D emas 3D fikirlang  Alisher  Isaev", "523 ming marta"))

        val members = ArrayList<Member>()
        members.add(Member(Feed("vqLoGp1u76w", " 1:20:00 ", R.drawable.im_user, "Dasturlashni nimadan boshlash kerak?", "Pdp Academy-4.4ming marta")))
        members.add(Member(Feed("W5FxcGiezio", " 1:20:00 ", R.drawable.im_user, "Dasturlashni nimadan boshlash kerak?", "Pdp Academy-4.4ming marta")))
        members.add(Member(stories))
        members.add(Member(Feed("xSFk1wec4-o", " 1:20:00 ", R.drawable.im_user, "Dasturlashni nimadan boshlash kerak?", "Pdp Academy-4.4ming marta")))
        members.add(Member(Feed("9s-Pi9Qt_U", " 1:20:00 ", R.drawable.im_user, "Dasturlashni nimadan boshlash kerak?", "Pdp Academy-4.4ming marta")))
        members.add(Member(Feed("n0N_4N_wbRw", " 1:20:00 ", R.drawable.im_user, "Dasturlashni nimadan boshlash kerak?", "Pdp Academy-4.4ming marta")))
        members.add(Member(Feed("-cBR33YjH4U", " 1:20:00 ", R.drawable.im_user, "Dasturlashni nimadan boshlash kerak?", "Pdp Academy-4.4ming marta")))


        return members
    }

    private fun refreshFilterAdapter(items: ArrayList<Filter>) {
        var adapter = FilterAdapter(this, items)
        recyclerFilter.adapter = adapter
    }

    private fun getAllFilter(): ArrayList<Filter> {
        var items = ArrayList<Filter>()

        items.add(Filter("Explore"))
        items.add(Filter("All"))
        items.add(Filter("Masha and the Bear"))
        items.add(Filter("Explore"))
        items.add(Filter("Explore"))
        items.add(Filter("Explore"))

        return items
    }
}