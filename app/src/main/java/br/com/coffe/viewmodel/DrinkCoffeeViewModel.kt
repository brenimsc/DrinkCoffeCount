package br.com.coffe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.coffe.utils.PreferencesUtils
import br.com.coffe.utils.PreferencesUtils.Companion.KEY_COFFEE_COUNT

class DrinkCoffeeViewModel : ViewModel() {

    private val _coffeeCounter = MutableLiveData<Int>()

    val coffeeCounter: LiveData<Int>
        get() = _coffeeCounter

    init {
        _coffeeCounter.value = 0
    }

    suspend fun incrementCounter() {
        _coffeeCounter.value = _coffeeCounter.value?.plus(1)
        val valor = _coffeeCounter.value
        PreferencesUtils.save(KEY_COFFEE_COUNT, valor ?:  0)
    }

    suspend fun resetCounter(): Boolean {
        _coffeeCounter.value = 0
        PreferencesUtils.save(KEY_COFFEE_COUNT, 0)
        return true
    }

    suspend fun loadCounter() {
        _coffeeCounter.value = PreferencesUtils.read(KEY_COFFEE_COUNT)
    }


}