package com.richardson.githubbest.ui

import android.os.Bundle
import android.os.Handler
import com.richardson.githubbest.R
import com.richardson.githubbest.ui.main.MainActivity
import org.jetbrains.anko.startActivity

class SplashActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            if(isNetworkConnected()) {
                startActivity<MainActivity>()
                finish()
            }
            else
                showErrorAlert(getString(R.string.error_no_connection), yesCallback = {finish()})
        }, 2000)
    }
}