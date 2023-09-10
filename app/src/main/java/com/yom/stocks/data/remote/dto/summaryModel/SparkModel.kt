package com.yom.stocks.data.remote.dto.summaryModel


import com.google.gson.annotations.SerializedName

data class SparkModel(
    @SerializedName("chartPreviousClose")
    val chartPreviousClose: Double?,
    @SerializedName("close")
    val close: List<Double?>?,
    @SerializedName("dataGranularity")
    val dataGranularity: Int?,
    @SerializedName("end")
    val end: Int?,
    @SerializedName("previousClose")
    val previousClose: Double?,
    @SerializedName("start")
    val start: Int?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("timestamp")
    val timestamp: List<Int?>?
)