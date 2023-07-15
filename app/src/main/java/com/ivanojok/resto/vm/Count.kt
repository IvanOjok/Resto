package com.ivanojok.resto.vm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ivanojok.resto.BR
import com.ivanojok.resto.R
import com.ivanojok.resto.data.FoodModel
import com.ivanojok.resto.databinding.ActivityCountBinding

class Count : AppCompatActivity() {

    private lateinit var countViewModel: CountViewModel

    val vm: CountViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_count)

//        countViewModel = ViewModelProvider(this).get(CountViewModel::class.java)
//
//        val count = findViewById<Button>(R.id.count_button)
//        val text = findViewById<TextView>(R.id.number_text)
//
//        count.setOnClickListener {
//            val y = countViewModel.increment()
//            text.text = y.toString()
//        }

        val binding: ActivityCountBinding = DataBindingUtil.setContentView(this, R.layout.activity_count)
        val f = FoodModel("", "", "")
        countViewModel = ViewModelProvider(this).get(CountViewModel::class.java)
        binding.setVariable(BR.viewModel, countViewModel)
        binding.setVariable(BR.food, f)
        binding.executePendingBindings()
    }
}