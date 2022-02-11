package com.phani

import androidx.lifecycle.ViewModel
import com.phani.data.DataRepository
import com.phani.data.Profile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ProfileViewModel @Inject constructor(private val repo:DataRepository): ViewModel() {


    fun getProfile(): Profile =repo.getProfile();
}