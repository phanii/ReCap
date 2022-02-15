package com.phani.user.viewmodel

import android.app.Application
import android.util.Log
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

      suspend fun insertUser(user: User)=  userRepo.createUser(user)



}