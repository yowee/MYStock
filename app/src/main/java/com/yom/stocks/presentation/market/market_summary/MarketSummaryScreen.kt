package com.yom.stocks.presentation.market.market_summary

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.yom.stocks.presentation.market.market_summary.component.MarketSummaryItem

@Composable
fun MarketSummaryScreen(
    navController: NavController,
    viewModel: MarketSummaryViewModel = hiltViewModel(), context : Context
) {

    val state = viewModel.state.value


    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.data ?: emptyList()) { summary ->
                MarketSummaryItem(summary = summary, onItemClick = {}, context = context)
            }
        }
    }

}
