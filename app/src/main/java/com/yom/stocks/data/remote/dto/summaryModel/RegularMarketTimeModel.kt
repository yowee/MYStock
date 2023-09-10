package com.yom.stocks.data.remote.dto.summaryModel


import com.google.gson.annotations.SerializedName

data class RegularMarketTimeModel(
    @SerializedName("fmt")
    val fmt: String?,
    @SerializedName("raw")
    val raw: Int?
)