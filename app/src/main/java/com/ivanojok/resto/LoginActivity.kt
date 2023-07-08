package com.ivanojok.resto

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.ivanojok.resto.data.Preferences

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailId = findViewById<TextInputEditText>(R.id.email)
        val passwordId = findViewById<TextInputEditText>(R.id.password)
        val signId = findViewById<Button>(R.id.signin)

        val preferences = Preferences(this).sharedPreferences


        if (preferences.getString("emailKey", null) != null && preferences.getString("passwordKey", null) != null){
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "You're not logged in", Toast.LENGTH_LONG).show()
        }

        signId.setOnClickListener {
            val editor = preferences.edit()
            val email = emailId.text.toString()
            val password = passwordId.text.toString()

            editor.putString("emailKey", email)
            editor.putString("passwordKey", password)
            editor.apply()
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}