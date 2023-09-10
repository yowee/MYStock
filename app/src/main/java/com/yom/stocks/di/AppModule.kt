package com.yom.stocks.di

import com.yom.stocks.common.Constants
import com.yom.stocks.data.remote.YahooFinanceApi
import com.yom.stocks.data.repository.MarketRepositoryImpl
import com.yom.stocks.domain.repository.MarketRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideYahooFinanceApi(): YahooFinanceApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(YahooFinanceApi::class.java)
    }


    @Provides
    fun provideMarketRepository(yahooFinanceApi: YahooFinanceApi): MarketRepository {
        return MarketRepositoryImpl(yahooFinanceApi);
    }


}