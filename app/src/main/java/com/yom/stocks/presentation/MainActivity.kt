package com.yom.stocks.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.yom.stocks.presentation.firebase_login_signup.SignInScreen
import com.yom.stocks.presentation.firebase_login_signup.SignUpScreen
import com.yom.stocks.presentation.market.market_summary.MarketSummaryScreen
import com.yom.stocks.presentation.navigation.AppRoutes
import com.yom.stocks.presentation.theme.ui.StocksTheme
import com.yom.stocks.presentation.theme.ui.colorOffWhite
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth;
    private var customToken: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StocksTheme {
                Surface(contentColor = colorOffWhite) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = AppRoutes.Main
                    ) {
                        composable(AppRoutes.Main) {
                            MainScreen(navController, applicationContext)
                        }
                        composable(AppRoutes.SignIn) {
                            SignInScreen(navController)
                        }
                        composable(AppRoutes.SignUp) {
                            SignUpScreen(navController)
                        }
                        composable(AppRoutes.MarketSummary) {
                            MarketSummaryScreen(navController, context = applicationContext)
                        }

                    }

                }
            }
        }

    }


}