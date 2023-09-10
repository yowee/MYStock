package com.yom.stocks.data.remote.dto.summaryModel


import com.google.gson.annotations.SerializedName

data class MarketSummaryModel(
    @SerializedName("marketSummaryAndSparkResponse")
    val marketSummaryAndSparkResponse: MarketSummaryAndSparkResponseModel?
)