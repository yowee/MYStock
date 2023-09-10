package com.yom.stocks.presentation.market.market_summary

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yom.stocks.common.Resource
import com.yom.stocks.data.remote.dto.summaryModel.ResultModel
import com.yom.stocks.domain.use_case.market.get_market_summary.GetMarketSummaryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MarketSummaryViewModel @Inject constructor(val getMarketSummaryUseCase: GetMarketSummaryUseCase) :
    ViewModel() {


    private val _state = mutableStateOf(MarketSummaryState())
    val state: State<MarketSummaryState> = _state

    init {
        getMarketSummary()
    }

    private fun getMarketSummary() {
        getMarketSummaryUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MarketSummaryState(data = result.data?.marketSummaryAndSparkResponse?.result as List<ResultModel>?)
                }
                is Resource.Loading -> {
                    _state.value = MarketSummaryState(isLoading = true)}
                is Resource.Error -> {
                    _state.value = MarketSummaryState(error = result.message ?: "Unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }



}