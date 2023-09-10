package com.yom.stocks.presentation.market.market_summary

import com.yom.stocks.data.remote.dto.summaryModel.ResultModel

data class MarketSummaryState(
    val isLoading: Boolean = false,
    val data: List<ResultModel>? = emptyList(),
    val error: String = "")