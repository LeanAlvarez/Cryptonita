package com.mirai.cryptonita.data.model

data class Coin(val id: String = "",
                val symbol: String = "",
                val name: String = "",
                val image: String = "",
                val current_price: Double = -1.0,
                val market_cap: Long = -1,
                val market_cap_rank: Int = -1,
                val total_volume: Double = -1.0,
                val high_24h: Double = -1.0,
                val low_24h: Double = -1.0,
                val price_change_24h: Double = -1.0,
                val price_change_percentage_24h: Double = -1.0,
                val market_cap_change_24h: Double = -1.0,
                val market_cap_change_percentage_24h: Double = -1.0,
                val circulating_supply: Double = -1.0,
                val atl_date: String = "",
                val last_updated: String = ""
)

data class CoinList(val coins:Coin)