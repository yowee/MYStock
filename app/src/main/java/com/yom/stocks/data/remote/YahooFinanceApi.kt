package com.yom.stocks.data.remote

import com.yom.stocks.common.Constants
import com.yom.stocks.data.remote.dto.summaryModel.MarketSummaryModel
import retrofit2.http.GET
import retrofit2.http.Headers

interface YahooFinanceApi {

    @Headers(
        "${Constants.X_RapidAPI_Header_Host}:${Constants.X_RapidAPI_Host}",
        "${Constants.X_RAPID_AUTH_HEADER_KEY}:${Constants.X_RapidAPI_Key}"
    )
    @GET(Constants.SUMMARY_END_POINT)
    suspend fun getMarketSummary(): MarketSummaryModel
}