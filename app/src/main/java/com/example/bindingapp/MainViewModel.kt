package com.example.bindingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    fun updateName(name:String){
        _name.postValue(name)
    }

}