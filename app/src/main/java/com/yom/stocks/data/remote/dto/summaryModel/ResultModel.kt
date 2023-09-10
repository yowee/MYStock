package com.yom.stocks.data.remote.dto.summaryModel


import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("cryptoTradeable")
    val cryptoTradeable: Boolean?,
    @SerializedName("customPriceAlertConfidence")
    val customPriceAlertConfidence: String?,
    @SerializedName("exchange")
    val exchange: String?,
    @SerializedName("exchangeDataDelayedBy")
    val exchangeDataDelayedBy: Int?,
    @SerializedName("exchangeTimezoneName")
    val exchangeTimezoneName: String?,
    @SerializedName("exchangeTimezoneShortName")
    val exchangeTimezoneShortName: String?,
    @SerializedName("firstTradeDateMilliseconds")
    val firstTradeDateMilliseconds: Long?,
    @SerializedName("fullExchangeName")
    val fullExchangeName: String?,
    @SerializedName("gmtOffSetMilliseconds")
    val gmtOffSetMilliseconds: Int?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("market")
    val market: String?,
    @SerializedName("marketState")
    val marketState: String?,
    @SerializedName("priceHint")
    val priceHint: Int?,
    @SerializedName("quoteType")
    val quoteType: String?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("regularMarketPreviousClose")
    val regularMarketPreviousClose: RegularMarketPreviousCloseModel?,
    @SerializedName("regularMarketTime")
    val regularMarketTime: RegularMarketTimeModel?,
    @SerializedName("shortName")
    val shortName: String?,
    @SerializedName("sourceInterval")
    val sourceInterval: Int?,
    @SerializedName("spark")
    val spark: SparkModel?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("tradeable")
    val tradeable: Boolean?,
    @SerializedName("triggerable")
    val triggerable: Boolean?
)