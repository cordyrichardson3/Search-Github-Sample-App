package com.richardson.githubbest.ui

import com.richardson.githubbest.utils.isConnectivityDetected
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton

fun BaseActivity.showErrorAlert(errorMessage: String, yesCallback:() -> Unit = {},
                                noCallback:() -> Unit = {}) {
    if(isActive())
        alert(errorMessage){
            yesButton{yesCallback.invoke()}
            noButton{noCallback.invoke()}
        }.show()

}

fun BaseActivity.isNetworkConnected() = isConnectivityDetected(this)