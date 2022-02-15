package com.phani.user.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.phani.user.model.User
import com.phani.user.db.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepo: UserRepo,
    applicationContext: Application
) :
    AndroidViewModel(applicationContext) {


    private val _response = MutableLiveData<Long>()
    val response: LiveData<Long> = _response

    fun insertUser(user: User)
    {
        viewModelScope.launch (Dispatchers.IO){
            userRepo.createUser(user)
        }
    }
}