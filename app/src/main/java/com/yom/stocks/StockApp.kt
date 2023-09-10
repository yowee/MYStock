package com.yom.stocks

import android.app.Application
import com.paypal.checkout.PayPalCheckout
import com.paypal.checkout.config.CheckoutConfig
import com.paypal.checkout.config.Environment
import com.paypal.checkout.config.SettingsConfig
import com.paypal.checkout.createorder.CurrencyCode
import com.paypal.checkout.createorder.UserAction

import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StockApp : Application(){
    var clientId = "AbSDXhw06-_Jp7Od0tr-LmEcRg8jKnoR0Fx0f9UE4Xdzqbz_nz8Pbt99kCyPpK1cTpGtEaKh9mLij-Fq"
    var returnUrl = "com.yom.stocks://paypalpay"

    override fun onCreate() {
        super.onCreate()
        val config = CheckoutConfig(
            application = this,
            clientId = clientId,
            environment = Environment.SANDBOX,
            returnUrl = returnUrl,
            currencyCode = CurrencyCode.USD,
            userAction = UserAction.PAY_NOW,
            settingsConfig = SettingsConfig(
                loggingEnabled = true
            )
        )
        PayPalCheckout.setConfig(config)
    }
}