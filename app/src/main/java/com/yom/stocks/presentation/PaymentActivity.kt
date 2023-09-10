package com.yom.stocks.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.paypal.checkout.approve.OnApprove
import com.paypal.checkout.cancel.OnCancel
import com.paypal.checkout.createorder.CreateOrder
import com.paypal.checkout.createorder.CurrencyCode
import com.paypal.checkout.createorder.OrderIntent
import com.paypal.checkout.createorder.UserAction
import com.paypal.checkout.error.OnError
import com.paypal.checkout.order.Amount
import com.paypal.checkout.order.AppContext
import com.paypal.checkout.order.OrderRequest
import com.paypal.checkout.order.PurchaseUnit
import com.paypal.checkout.paymentbutton.PaymentButtonContainer
import com.yom.stocks.R


class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.paypalcheckout)

        val amountToBuy = intent.getStringExtra("AMOUNT_TO_BUY")


        val  paymentButton = findViewById<PaymentButtonContainer>(R.id.payment_button_container)

        paymentButton.setup(
            createOrder = CreateOrder { createOrderActions ->
                val order =
                    OrderRequest(
                        intent = OrderIntent.CAPTURE,
                        appContext = AppContext(userAction = UserAction.PAY_NOW),
                        purchaseUnitList =
                        listOf(
                            PurchaseUnit(
                                amount =
                                Amount(currencyCode = CurrencyCode.USD, value = amountToBuy!!)
                            )
                        )
                    )
                createOrderActions.create(order)
            },
            onApprove =
            OnApprove { approval ->
                approval.orderActions.capture { captureOrderResult ->
                    Toast.makeText(this,"Paymet Successfull", Toast.LENGTH_SHORT).show()
                }
            },
            onCancel = OnCancel {
                Toast.makeText(this,"Payment cancelled", Toast.LENGTH_SHORT).show()
            },
            onError = OnError { errorInfo ->
                Toast.makeText(this,"Payment error", Toast.LENGTH_SHORT).show()
            }

        )

    }

}



