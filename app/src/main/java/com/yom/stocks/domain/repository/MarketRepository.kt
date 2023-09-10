package com.yom.stocks.domain.repository

import com.yom.stocks.data.remote.dto.summaryModel.MarketSummaryModel

interface MarketRepository {
    suspend fun getMarketSummary(): MarketSummaryModel
}