package com.icanerdogan.oneandtwowaybinding.viewmodel


import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.icanerdogan.oneandtwowaybinding.data.FruitRepository

class MainViewModel : ViewModel() {
    val currentRandomFruitName: LiveData<String>
        get() = FruitRepository.currentRandomFruitName

    fun onChangeRandomFruitClick() = FruitRepository.changeCurrentRandomFruitName()

    @Bindable
    val editTextContent = MutableLiveData<String>()

    private val _displayedEditTextContent = MutableLiveData<String>()

    val displayedEditTextContent : LiveData<String>
        get() = _displayedEditTextContent

    fun onDisplayEditTextContentClick(){
        _displayedEditTextContent.value = editTextContent.value
    }

    fun onSelectRandomEditTextFruit(){
        editTextContent.value = FruitRepository.getRandomFruitName()
    }
}