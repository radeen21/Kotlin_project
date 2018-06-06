package com.example.administrator.kotlinproject.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.administrator.kotlinproject.R
import com.example.administrator.kotlinproject.model.News

/**
 * Created by Administrator on 5/28/2018.
 */
class Holder(itemView: View?, var newsHolderListener: NewsHolderListener) : RecyclerView.ViewHolder(itemView) {

     var txt_main_holder : TextView? = null
     var img_main : ImageView? = null
     var context : Context? = null

    init {
        this.context = itemView?.getContext()
        setOnNewsListener(newsHolderListener)
        txt_main_holder = itemView?.findViewById(R.id.txt_main_holder)
        img_main = itemView?.findViewById(R.id.img_main)
    }

    fun setOnNewsView(news: News) {
        try {
            Glide.with(context)
                    .load(news.urlToImage)
                    .into(img_main)

            txt_main_holder?.text = news.title
        }catch (e : Exception){
            Log.d("Context", String.toString())

        }
    }

     fun setOnNewsListener(newsHolderListener: NewsHolderListener) {
        this.newsHolderListener = newsHolderListener
    }

    interface NewsHolderListener{
        fun onNewsListener(news : News)
    }

}