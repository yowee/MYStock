package com.yom.stocks.presentation.market.market_summary.component

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.yom.stocks.data.remote.dto.summaryModel.ResultModel
import com.yom.stocks.presentation.market.market_summary.market_details_screen.MarketDetailsScreen
import com.yom.stocks.presentation.navigation.AppRoutes

@Composable
fun MarketSummaryItem(
    summary: ResultModel?,
    onItemClick: (ResultModel) -> Unit, context: Context
) {
    var showMarketDetails by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .clickable { onItemClick(summary!!) }
        ) {
            Text(
                text = "${summary?.fullExchangeName} (${summary?.symbol?.substring(1)})",
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${summary?.regularMarketPreviousClose?.fmt}",
                color = Color.Green,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {

                    showMarketDetails = true


                },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Buy", color = MaterialTheme.colorScheme.primary)
            }

            Button(
                onClick = {
                    // Handle the sell action here
                },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Sell", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
    // Show MarketDetailsScreen if the flag is true
    if (showMarketDetails) {
        MarketDetailsScreen(selectedItem = summary, context)
    }
}




@Composable
@Preview
fun previewMe() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
//        MarketSummaryItem(null, {})
    }
}