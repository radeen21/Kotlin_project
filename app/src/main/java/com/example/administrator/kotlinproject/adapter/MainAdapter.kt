package com.example.administrator.kotlinproject.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.administrator.kotlinproject.R
import com.example.administrator.kotlinproject.model.News
import com.example.administrator.kotlinproject.view.Holder
import com.h6ah4i.android.widget.advrecyclerview.utils.RecyclerViewAdapterUtils
import com.h6ah4i.android.widget.advrecyclerview.utils.RecyclerViewAdapterUtils.getViewHolder
import java.util.ArrayList

/**
 * Created by Administrator on 5/28/2018.
 */
class MainAdapter(val holdermain: Holder.NewsHolderListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var news: MutableList<News> = mutableListOf()

//    fun MainAdapter(news : ArrayList<News>){
//        this.news.addAll(news)
//        this.news = news
//    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        val layoutInflater = LayoutInflater.from(parent?.getContext())

        viewHolder = getViewHolder(parent,layoutInflater)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is Holder) run {
            val newses = news.get(position)
            val newsViewHolder = holder
            newsViewHolder.setOnNewsView(newses)
        }
    }

    override fun getItemCount(): Int {
        return news.size
    }

    fun addBrands(news: java.util.ArrayList<News>) {
        this.news = news
        notifyDataSetChanged()
    }

    private fun getViewHolder(parent: ViewGroup?, layoutInflater: LayoutInflater ): RecyclerView.ViewHolder {
        val holderMain: RecyclerView.ViewHolder
        val view = layoutInflater.inflate(R.layout.main_item, parent, false)

        holderMain = Holder(view, holdermain)

        return holderMain
    }

}