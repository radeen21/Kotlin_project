package com.example.administrator.kotlinproject

import com.example.administrator.kotlinproject.service.EventApi

/**
 * Created by Administrator on 5/24/2018.
 */
interface IMainPresenter {

    fun loadEventData ()

    fun loadNews (source : String, apiKey : String)

    fun start()
}