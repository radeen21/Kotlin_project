package com.example.administrator.kotlinproject.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.administrator.kotlinproject.R
import com.example.administrator.kotlinproject.model.News
import kotlinx.android.synthetic.main.main_item.*
/**
 * Created by Administrator on 5/28/2018.
 */
class MainHolder(itemView: View?, var newsHolderListener: NewsHolderListener) : RecyclerView.ViewHolder(itemView) {

     var txt_main_holder : TextView? = null
     var context : Context? = null

    init {
        this.context = itemView?.getContext()
        setOnNewsListener(newsHolderListener)
        txt_main_holder = itemView?.findViewById(R.id.txt_main_holder)
    }

    fun setOnNewsView(news: News) {
        try {
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