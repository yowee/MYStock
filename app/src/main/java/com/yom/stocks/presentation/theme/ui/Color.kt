package com.yom.stocks.presentation.theme.ui

import android.provider.CalendarContract
import androidx.compose.ui.graphics.Color
import androidx.compose.material.darkColors
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember





val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val colorPrimary = Color(0xFFFC5C7D)
val colorPrimaryDark = Color(0xFFCE1CFF)
val colorAccent = Color(0xFF9AB3FF)
val colorAccentVariant = Color(0xFF3457D5)
val colorRedError = Color(0xFFFF9494)
val colorSuccessGreen = Color(0xFF59C351)
val darkBackgroundColor = Color(0xFF000000)
val colorOffWhite = Color(0xFFE7E7E7)
val transparent = Color(0x00000000)
val black = Color(0xFF000000)
val lightGray = Color(0xFFCCCCCC)


val StocksColor = darkColors(
    primary = colorPrimary,
    onPrimary = black,
    primaryVariant = colorPrimaryDark,
    secondary = colorAccent,
    onSecondary = black,
    error = colorRedError,
    onError = black,
    surface = darkBackgroundColor,
    background = darkBackgroundColor,
    onSurface = lightGray,
    onBackground = lightGray
)


