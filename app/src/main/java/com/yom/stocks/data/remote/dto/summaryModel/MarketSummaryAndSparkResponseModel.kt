package com.yom.stocks.data.remote.dto.summaryModel


import com.google.gson.annotations.SerializedName

data class MarketSummaryAndSparkResponseModel(
    @SerializedName("error")
    val error: Any?,
    @SerializedName("result")
    val result: List<ResultModel?>?
)