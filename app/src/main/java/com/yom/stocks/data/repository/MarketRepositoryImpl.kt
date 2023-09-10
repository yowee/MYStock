package com.yom.stocks.data.repository

import com.yom.stocks.data.remote.YahooFinanceApi
import com.yom.stocks.data.remote.dto.summaryModel.MarketSummaryModel
import com.yom.stocks.domain.repository.MarketRepository
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(private val yahooFinanceApi: YahooFinanceApi) :
    MarketRepository {
    override suspend fun getMarketSummary(): MarketSummaryModel = yahooFinanceApi.getMarketSummary()
}