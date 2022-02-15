package com.phani.preference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "data_storage")

@Singleton
class PreferenceImpl @Inject constructor(@ApplicationContext context: Context) : PreferenceStorage {

    private val dataStore = context.dataStore

    private object PreferenceKeys {
        val SAVED_KEY = booleanPreferencesKey("saved_key")
    }

    override fun savedKey() = dataStore.data.catch { it ->
        if (it is IOException) {
            emit(emptyPreferences())
        } else
            throw it
    }.map { it[PreferenceKeys.SAVED_KEY] ?: false }


    override suspend fun setSavedKey(order: Boolean) {

        dataStore.edit {
            it[PreferenceKeys.SAVED_KEY] = order
        }
    }

}