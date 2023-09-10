package com.yom.stocks.presentation.market.market_summary.market_details_screen

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.yom.stocks.data.remote.dto.summaryModel.ResultModel
import com.yom.stocks.presentation.PaymentActivity


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketDetailsScreen(selectedItem: ResultModel?, context: Context) {
    var amountToBuy by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        Text(
            text = "Market Details",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Display item details
        selectedItem?.let { item ->
            MarketDetailItem("Item Name", item.fullExchangeName ?: "N/A")
            MarketDetailItem("Symbol", item.symbol ?: "N/A")
            MarketDetailItem("Exchange", item.exchange ?: "N/A")
            MarketDetailItem("Market State", item.marketState ?: "N/A")

            // Add more details as needed
            MarketDetailItem("Previous Close", item.regularMarketPreviousClose?.fmt ?: "N/A")
        }

        // Create a Row to place the TextField and Button next to each other
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Number field to select the amount to buy with custom border
            TextField(
                value = amountToBuy.toString(),
                onValueChange = { newValue ->
                    // Update the amountToBuy when the user enters a valid number
                    if (newValue.isNotBlank()) {
                        amountToBuy = newValue.toDouble()
                    } else {
                        amountToBuy = 0.0
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 8.dp)
                    .align(Alignment.CenterVertically)
                ,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                ),
                shape = MaterialTheme.shapes.small,
                singleLine = true,
            )

            PayButton(context,amountToBuy.toString())
        }
    }
}


@Composable
private fun MarketDetailItem(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Text(
            text = label,
//            style = MaterialTheme.typography.,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = value,
//            style = MaterialTheme.typography.,
//            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun PayButton(context : Context, amountToBuy : String) {
    Button(onClick = {
        val intent = Intent(context, PaymentActivity::class.java)
        intent.putExtra("AMOUNT_TO_BUY", amountToBuy)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }){
        Text(text = "Pay")
    }
}

