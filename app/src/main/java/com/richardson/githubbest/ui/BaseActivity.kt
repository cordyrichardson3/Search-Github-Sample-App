package com.richardson.githubbest.ui

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    fun isActive() = !isFinishing
}