package br.com.coffe.utils

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import br.com.coffe.dataStore
import kotlinx.coroutines.flow.first

class PreferencesUtils {

    companion object{
        const val KEY_COFFEE_COUNT = "br.com.chicorialabs.drinkcoffee.COFFEE_COUNTER"

        suspend fun save(key: String, value: Int) {
            val dataStoreKey = preferencesKey<Int>(key)
            dataStore.edit { coffeeCount ->
                coffeeCount[dataStoreKey] = value
            }
        }

        suspend fun read(key: String): Int? {
            val dataStoreKey = preferencesKey<Int>(key)
            val preferences = dataStore.data.first()
            return preferences[dataStoreKey]
        }

    }
}