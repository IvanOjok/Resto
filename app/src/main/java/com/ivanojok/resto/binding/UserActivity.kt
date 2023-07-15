package com.ivanojok.resto.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.ivanojok.resto.R
import com.ivanojok.resto.BR
import com.ivanojok.resto.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityUserBinding = DataBindingUtil.setContentView(this, R.layout.activity_user)



        binding.button.setOnClickListener {
            val email = binding.emailId.text.toString()
            val password = binding.passwordId.text.toString()
            val user = User(email, password)

            binding.emailText.visibility = View.VISIBLE
            binding.passwordText.visibility = View.VISIBLE

            binding.setVariable(BR.user, user)
            binding.executePendingBindings()
        }
    }
}