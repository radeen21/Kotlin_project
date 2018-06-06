package com.example.administrator.kotlinproject.root

import com.example.administrator.kotlinproject.service.EventApi

/**
 * Created by Administrator on 5/25/2018.
 */
interface IBaseViewPresenter {

    fun getEventApi() : EventApi
}