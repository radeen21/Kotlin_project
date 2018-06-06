package com.example.administrator.kotlinproject.service

import com.example.administrator.kotlinproject.service.response.WrapperEvent
import com.example.administrator.kotlinproject.service.response.WrapperNews
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import rx.Observable

/**
 * Created by Administrator on 5/23/2018.
 */
interface EventApi {

    @GET("s/0f2lcjzhqnj79dc/member.json")
    fun getResponse(): Observable<WrapperEvent>


    @GET("v2/top-headlines")
    fun getResponses(@Query ("sources") sources : String,@Query ("apiKey") apiKey : String) : Observable<WrapperNews>
}