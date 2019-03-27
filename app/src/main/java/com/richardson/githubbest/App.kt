package com.richardson.githubbest

import android.app.Application
import com.richardson.githubbest.dagger.DaggerDataAccessComponent
import com.richardson.githubbest.dagger.DataAccessComponent

class App: Application() {
    val dataAccessComponent:DataAccessComponent by lazy{ DaggerDataAccessComponent.create() }
}