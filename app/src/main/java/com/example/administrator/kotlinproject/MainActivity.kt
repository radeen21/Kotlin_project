package com.example.administrator.kotlinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.administrator.kotlinproject.adapter.MainAdapter
import com.example.administrator.kotlinproject.model.Event
import com.example.administrator.kotlinproject.model.News
import com.example.administrator.kotlinproject.view.Holder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMainView, Holder.NewsHolderListener {

    private val TAG = MainActivity::class.java!!.getSimpleName()

    lateinit var mainPresenter: MainPresenter
    lateinit var newsAdapter: MainAdapter
    var llManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        mainPresenter.start()

        initialize()
    }

    fun initialize() {
        newsAdapter = MainAdapter(this)
        llManager = LinearLayoutManager(this)
        recycler_main.layoutManager = llManager
        recycler_main.setHasFixedSize(true)
        recycler_main.adapter = newsAdapter
    }

    override fun loadViewEvent(events: Event) {

    }

    override fun loadViewNews(news: ArrayList<News>) {
        newsAdapter.addBrands(news)

        recycler_main.visibility = View.VISIBLE
        progress_main.visibility = View.GONE
    }

    override fun onNewsListener(news: News) {

    }
}
