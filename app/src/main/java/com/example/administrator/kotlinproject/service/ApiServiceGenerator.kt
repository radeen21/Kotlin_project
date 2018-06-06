package com.example.administrator.kotlinproject.service

import com.example.administrator.kotlinproject.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Administrator on 5/23/2018.
 */
class ApiServiceGenerator {

    private val API_BASE_URL : String? = BuildConfig.URL_API_SERVICE
    private val httpClient : OkHttpClient.Builder = OkHttpClient.Builder()

    private val builder : Retrofit.Builder =
            Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S? {
        return createService(serviceClass, null)
    }

    fun <S> createService(servicClass: Class<S>,authToken: String?) : S? {
        if (authToken != null){
            httpClient.addInterceptor { chain ->
                val original = chain.request()

                // Request customization: add request headers
                val requestBuilder = original.newBuilder()
                        .header("Authorization", authToken)
                        .method(original.method(), original.body())

                val request = requestBuilder.build()
                chain.proceed(request)
            }
        }

        var client : OkHttpClient? = httpClient.build()
        var retrofit : Retrofit? = builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(client).build()
        return retrofit?.create(servicClass)
    }

}