package com.richardson.githubbest.utils

import android.content.Context
import android.net.ConnectivityManager

fun isConnectivityDetected(context: Context): Boolean{
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return connectivityManager.activeNetworkInfo?.isConnected == true
}