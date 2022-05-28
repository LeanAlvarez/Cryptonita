package com.mirai.cryptonita.repository

import com.mirai.cryptonita.data.model.Coin
import com.mirai.cryptonita.data.model.Exchanges
import com.mirai.cryptonita.data.model.TrendingList
import com.mirai.cryptonita.data.remote.CoinDataSource
import javax.sql.CommonDataSource

class CoinRepositoryImpl(private val dataSource: CoinDataSource): CoinRepository {
    override suspend fun getCoins(): List<Coin> = dataSource.getCoins()

    override suspend fun getExchanges(): List<Exchanges> = dataSource.getExchanges()

    override suspend fun getTrending(): TrendingList = dataSource.getTrending()

}