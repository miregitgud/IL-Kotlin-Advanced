package com.example.kotlinadvanced.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _data = MutableLiveData<String>()

    val data: LiveData<String>
        get() = _data

    fun updateData(newData: String) {
        _data.value = newData
    }
}
