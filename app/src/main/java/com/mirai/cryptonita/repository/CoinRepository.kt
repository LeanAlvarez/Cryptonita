package com.mirai.cryptonita.repository

import com.mirai.cryptonita.data.model.Coin
import com.mirai.cryptonita.data.model.Exchanges
import com.mirai.cryptonita.data.model.TrendingList

interface CoinRepository {

    suspend fun getCoins(): List<Coin>

    suspend fun getExchanges(): List<Exchanges>

    suspend fun getTrending(): TrendingList

}