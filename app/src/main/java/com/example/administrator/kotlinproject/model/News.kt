package com.example.administrator.kotlinproject.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Administrator on 5/28/2018.
 */
class News {

    var source : Sources? = null
    var author : String? = null
    var title : String? = null
    var description : String? = null
    var url : String? = null
    var urlToImage : String? = null
    var publishedAt : String? = null

    class Sources {
        var id : String? = null
        var name : String? = null
    }

}