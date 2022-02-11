package com.phani

import android.app.Application
import androidx.lifecycle.*
import com.phani.dog.data.Repository
import com.phani.dog.model.DogResponse
import com.phani.dog.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
) :
    AndroidViewModel(application) {

    private val _response: MutableLiveData<NetworkResult<DogResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<DogResponse>> = _response


    fun fetchDogResponse() = viewModelScope.launch {

        repository.getDog().collect { values -> _response.value = values }
    }
}