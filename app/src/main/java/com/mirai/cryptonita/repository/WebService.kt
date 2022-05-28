package com.mirai.cryptonita.repository

import com.google.gson.GsonBuilder
import com.mirai.cryptonita.application.AppConstants
import com.mirai.cryptonita.data.model.Coin
import com.mirai.cryptonita.data.model.Exchanges
import com.mirai.cryptonita.data.model.TrendingList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("coins/markets")
    suspend fun getCoins(@Query(value = "vs_currency") currency: String): List<Coin>

    @GET("exchanges")
    suspend fun getExchanges(): List<Exchanges>

    @GET("search/trending")
    suspend fun getTrending(): TrendingList


}


object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }


}