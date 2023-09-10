package com.yom.stocks.domain.use_case.market.get_market_summary

import android.util.Log
import com.yom.stocks.common.Resource
import com.yom.stocks.data.remote.dto.summaryModel.MarketSummaryModel
import com.yom.stocks.domain.repository.MarketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

const val TAG = "GetMarketSummaryUseCase"

class GetMarketSummaryUseCase @Inject constructor(private val marketRepository: MarketRepository) {

    operator fun invoke(): Flow<Resource<MarketSummaryModel>> = flow {
        try {
            emit(Resource.Loading<MarketSummaryModel>())
            val marketsummary = marketRepository.getMarketSummary()
            emit(Resource.Success<MarketSummaryModel>(marketsummary))
        } catch (e: HttpException) {
            emit(
                Resource.Error<MarketSummaryModel>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            Resource.Error<MarketSummaryModel>(
                e.localizedMessage ?: "Couldn't Reach server check your internet connection"
            )
        }
    }

}