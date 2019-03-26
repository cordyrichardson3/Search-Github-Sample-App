package com.richardson.githubbest.ui

import androidx.appcompat.app.AppCompatActivity
import com.richardson.githubbest.R
import org.jetbrains.anko.indeterminateProgressDialog

abstract class BaseActivity: AppCompatActivity() {

    fun isActive() = !isFinishing

}