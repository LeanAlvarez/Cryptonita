package com.mirai.cryptonita.data.remote

import com.mirai.cryptonita.data.model.Coin
import com.mirai.cryptonita.data.model.Exchanges
import com.mirai.cryptonita.data.model.TrendingList
import com.mirai.cryptonita.repository.WebService

class CoinDataSource(private val webService: WebService) {

    suspend fun getCoins(): List<Coin> = webService.getCoins("usd")

    suspend fun getTrending(): TrendingList = webService.getTrending()

    suspend fun getExchanges(): List<Exchanges> = webService.getExchanges()

}