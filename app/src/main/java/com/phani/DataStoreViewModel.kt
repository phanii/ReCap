package com.phani

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.phani.preference.PreferenceImpl
import com.phani.preference.PreferenceStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
public class  DataStoreViewModel @Inject constructor(private val preferenceStorage: PreferenceStorage,application: Application):AndroidViewModel(application)  {

val savedKey=preferenceStorage.savedKey().asLiveData()
    fun setSavedKey(key:Boolean)
    {
        viewModelScope.launch {
            preferenceStorage.setSavedKey(key)
        }
    }
}