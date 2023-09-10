# Stocks
Stocks is a android applications that displays latest stock market Summary and receive notification from firebase cloud

<img src="" width="240"/>
<img src="" width="240"/>
<img src="" width="240"/>



## Usage 
Generate new token from yahoo finance [Yahoo Finance](https://rapidapi.com/apidojo/api/yh-finance/)
Replace X_RapidAPI_Key value with your new token
```java
    const val BASE_URL = "https://yh-finance.p.rapidapi.com"
    const val SUMMARY_END_POINT = "/market/v2/get-summary"
    const val X_RAPID_AUTH_HEADER_KEY = "X-RapidAPI-Key"
    const val X_RapidAPI_Key = "99a4a73f35mshf573f9010bbd471p11c740jsnb30186cbb1e0"
    const val X_RapidAPI_Host = "yh-finance.p.rapidapi.com"
    const val X_RapidAPI_Header_Host = "X-RapidAPI-Host"
```
## Installation

[Clone Stocks](https://github.com/yowee/Stocks) and open run it in your ide


## Permissions


```java
Internet
Notification
```



# Features
Notification

# Architecture **"CLEAN"**
Dipendency Injection

Repository

ViewModel

Presentation

Use Cases

# Libraries

Compose

Retorfit

HILT

Gson

Mockito

Firebase

# API

Market summary: https://yh-finance.p.rapidapi.com/market/v2/get-summary
