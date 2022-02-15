package com.icanerdogan.oneandtwowaybinding.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

object FruitRepository {
    private val fruitNames: List<String> = listOf(
        "Apples",
        "pears",
        "oranges",
        "grapefruits",
        "mandarins",
        "limes",
        "nectarines",
        "apricots",
        "peaches",
        "plums",
        "bananas",
        "mangoes",
        "strawberries",
        "raspberries",
        "blueberries",
        "kiwifruit",
        "passionfruit",
        "watermelons",
        "rockmelons",
        "honeydew",
        "melons",
        "Tomatoes",
        "avocados"
    )

    private val _currentRandomFruitName = MutableLiveData<String>()
    val currentRandomFruitName: LiveData<String>
        get() = _currentRandomFruitName

    init {
        _currentRandomFruitName.value = fruitNames.first()
    }

    fun getRandomFruitName() : String{
        val random = java.util.Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName(){
        _currentRandomFruitName.value = getRandomFruitName()
    }
}