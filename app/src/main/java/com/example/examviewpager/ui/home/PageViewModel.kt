package com.example.examviewpager.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.examviewpager.R


class PageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        //"Hello world from section: $it"
        ""
    }
    val image: LiveData<Int> = Transformations.map(_index) {
        if(_index.value == 1){
            R.mipmap.pay_card_1
        }else{
            R.mipmap.pay_card_2
        }
    }
    fun setIndex(index: Int) {
        _index.value = index
    }
}