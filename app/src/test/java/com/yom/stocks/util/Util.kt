package com.yom.stocks.util

import com.yom.stocks.data.remote.dto.summaryModel.MarketSummaryAndSparkResponseModel
import com.yom.stocks.data.remote.dto.summaryModel.MarketSummaryModel
import com.yom.stocks.data.remote.dto.summaryModel.RegularMarketPreviousCloseModel
import com.yom.stocks.data.remote.dto.summaryModel.RegularMarketTimeModel
import com.yom.stocks.data.remote.dto.summaryModel.ResultModel
import com.yom.stocks.data.remote.dto.summaryModel.SparkModel

class Util {
    companion object {
        fun getSampleSummaryModelObject(): MarketSummaryModel {
            val previousCloseModel = RegularMarketPreviousCloseModel(
                fmt = "123.45",
                raw = 123.45
            )
            val marketTimeModel = RegularMarketTimeModel(
                fmt = "2023-07-26T14:30:00Z",
                raw = 1679983800
            )
            val sparkModel = SparkModel(
                chartPreviousClose = 100.0,
                close = listOf(101.0, 102.0, 103.0, 104.0, 105.0),
                dataGranularity = 1,
                end = 1679983800,
                previousClose = 100.0,
                start = 1679983200,
                symbol = "AAPL",
                timestamp = listOf(1679983200, 1679983260, 1679983320, 1679983380, 1679983440)
            )


            val resultModel = ResultModel(
                cryptoTradeable = true,
                customPriceAlertConfidence = "high",
                exchange = "NYSE",
                exchangeDataDelayedBy = 15,
                exchangeTimezoneName = "America/New_York",
                exchangeTimezoneShortName = "EDT",
                firstTradeDateMilliseconds = 1667325560000L,
                fullExchangeName = "New York Stock Exchange",
                gmtOffSetMilliseconds = -14400000,
                language = "en-US",
                market = "US",
                marketState = "REGULAR",
                priceHint = 2,
                quoteType = "EQUITY",
                region = "US",
                regularMarketPreviousClose = previousCloseModel,
                regularMarketTime = marketTimeModel,
                shortName = "AAPL",
                sourceInterval = 2,
                spark = sparkModel,
                symbol = "AAPL",
                tradeable = true,
                triggerable = true
            )

            val resultModel1 = resultModel
            val resultModelList = listOf(resultModel1)

            val marketSummaryAndSparkResponseModel = MarketSummaryAndSparkResponseModel(
                error = null,
                result = resultModelList
            )

            return MarketSummaryModel(marketSummaryAndSparkResponseModel)
        }

    }
}