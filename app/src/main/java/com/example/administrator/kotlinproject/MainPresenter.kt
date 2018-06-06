package com.example.administrator.kotlinproject

import android.content.ContentValues.TAG
import android.util.Log
import com.example.administrator.kotlinproject.service.ApiServiceGenerator
import com.example.administrator.kotlinproject.service.EventApi
import com.example.administrator.kotlinproject.service.response.WrapperEvent
import com.example.administrator.kotlinproject.service.response.WrapperNews
import rx.Observable
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Administrator on 5/24/2018.
 */
class MainPresenter(var listener: IMainView) : IMainPresenter {

    override fun start() {
        loadEventData()
        loadNews(toString(),apiKey = "3d7c688836904021b034444c64a43685")
    }

    override fun loadEventData() {
        val api = ApiServiceGenerator()
        val eventApi : EventApi? = api.createService(EventApi::class.java)

        val service: Observable<WrapperEvent>? = eventApi?.getResponse()

        service?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object: Observer<WrapperEvent> {
                    override fun onNext(wrapperEvent: WrapperEvent) {
                        Log.d(TAG, "onResponseEVENT: " + wrapperEvent.toString())
                        listener?.loadViewEvent(wrapperEvent.response!!)
                    }

                    override fun onError(e: Throwable?) {
                        Log.d(TAG, "onErrorEvent: " + e?.message)
                    }

                    override fun onCompleted() {

                    }

                })
    }

    override fun loadNews(source: String, apiKey: String) {
        val api = ApiServiceGenerator()
        val eventApi : EventApi? = api.createService(EventApi::class.java)

        val service: Observable<WrapperNews>? = eventApi?.getResponses("four-four-two", "3d7c688836904021b034444c64a43685")

        service?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object: Observer<WrapperNews> {
                    override fun onNext(wrapperNews: WrapperNews) {
                        Log.d(TAG, "onResponseNews: " + wrapperNews.toString())
                        listener.loadViewNews(wrapperNews.articles!!)
                    }

                    override fun onError(e: Throwable?) {
                        Log.d(TAG, "onErrorNews: " + e?.message)
                    }

                    override fun onCompleted() {

                    }

                })
    }

}