package com.example.youtubekotlin.model

class Member {
    var feed: Feed? = null
    var storys: ArrayList<Story> = ArrayList()

    constructor(feed: Feed){
        this.feed = feed
    }
    constructor(storys: ArrayList<Story>){
        this.storys = storys
    }
}