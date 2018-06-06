package com.example.administrator.kotlinproject

import com.example.administrator.kotlinproject.model.Event
import com.example.administrator.kotlinproject.model.News

/**
 * Created by Administrator on 5/24/2018.
 */
interface IMainView {

    fun loadViewEvent(events: Event)

    fun loadViewNews(news: ArrayList<News>)

}