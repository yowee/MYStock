package com.yom.stocks.data.repository

import com.google.errorprone.annotations.DoNotMock
import com.yom.stocks.data.remote.YahooFinanceApi
import com.yom.stocks.data.remote.dto.summaryModel.MarketSummaryAndSparkResponseModel
import com.yom.stocks.data.remote.dto.summaryModel.MarketSummaryModel
import com.yom.stocks.data.remote.dto.summaryModel.RegularMarketPreviousCloseModel
import com.yom.stocks.data.remote.dto.summaryModel.RegularMarketTimeModel
import com.yom.stocks.data.remote.dto.summaryModel.ResultModel
import com.yom.stocks.data.remote.dto.summaryModel.SparkModel
import com.yom.stocks.domain.repository.MarketRepository
import com.yom.stocks.util.Util
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class MarketRepositoryImplTest{

    lateinit var marketRepository: MarketRepository




    @Mock
    lateinit var yahooFinanceApi: YahooFinanceApi

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        marketRepository = MarketRepositoryImpl(yahooFinanceApi)
    }

    @Test
    fun whenGetSummaryReturnSummary() = runTest{

       val sumModel =  Util.getSampleSummaryModelObject()

        Mockito.`when`(yahooFinanceApi.getMarketSummary()).thenReturn(sumModel)
        marketRepository = MarketRepositoryImpl(yahooFinanceApi)

        assertEquals(marketRepository.getMarketSummary(), sumModel)
    }



}