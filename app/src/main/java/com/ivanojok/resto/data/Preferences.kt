package com.ivanojok.resto.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class Preferences(val context:Context) {

    val sharedPreferences = context.getSharedPreferences("login_credentials", AppCompatActivity.MODE_PRIVATE)
}