package com.yom.stocks.presentation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.yom.stocks.presentation.firebase_login_signup.SignInScreen
import com.yom.stocks.presentation.market.market_summary.MarketSummaryScreen

@Composable
fun MainScreen(navController : NavController, context: Context) {
    var isUserAuthenticated by remember { mutableStateOf(false) }

    FirebaseAuth.getInstance().addAuthStateListener { auth ->
        isUserAuthenticated = auth.currentUser != null
    }
    if (isUserAuthenticated) {
        MarketSummaryScreen(navController = navController, context = context)
    } else {
        SignInScreen(navController = navController)
    }
}


