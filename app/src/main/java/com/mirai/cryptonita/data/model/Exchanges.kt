package com.mirai.cryptonita.data.model


/*
"id": "binance",
    "name": "Binance",
    "year_established": 2017,
    "country": "Cayman Islands",
    "description": "",
    "url": "https://www.binance.com/",
    "image": "https://assets.coingecko.com/markets/images/52/small/binance.jpg?1519353250",
    "has_trading_incentive": false,
    "trust_score": 10,
    "trust_score_rank": 1,
    "trade_volume_24h_btc": 570394.9291209098,
    "trade_volume_24h_btc_normalized": 570394.9291209098
 */
data class Exchanges(
                    val id: String = "",
                    val name: String = "",
                    val year_established: Int = -1,
                    val country: String = "",
                    val description: String = "No Description",
                    val url: String = "",
                    val image: String = "",
                    val trust_score_rank: Int = -1,
                    val trade_volume_24h_btc: Double = -1.0,
)

data class ExchangeList(val exchange:List<Exchanges> = listOf())
