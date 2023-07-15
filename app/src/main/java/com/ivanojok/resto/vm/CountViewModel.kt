package com.ivanojok.resto.vm

import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    var inital = 10

    fun increment(): Int {
        val x = inital + 2
        return x
    }

}