package com.mirai.cryptonita.data.model

import com.google.gson.JsonArray


/*
"id": "terra-luna",
        "coin_id": 8284,
        "name": "Terra Luna Classic",
        "symbol": "LUNC",
        "market_cap_rank": 66,
        "thumb": "https://assets.coingecko.com/coins/images/8284/thumb/01_LunaClassic_color.png?1653547790",
        "small": "https://assets.coingecko.com/coins/images/8284/small/01_LunaClassic_color.png?1653547790",
        "large": "https://assets.coingecko.com/coins/images/8284/large/01_LunaClassic_color.png?1653547790",
        "slug": "terra-luna-classic",
        "price_btc": 4.582366904616872e-9,
        "score": 0
 */
data class Trending(
                    val id: String = "",
                    val coin_id: Int = -1,
                    val name: String = "",
                    val symbol: String = "",
                    val market_cap_rank: Int = -1,
                    val thumb: String = "",
                    val small: String = "",
                    val large: String = "",
                    val price_btc: Double = -1.0,
                    val score: Int = -1
)


data class TrendingList(val trending:List<Trending> = listOf())