package com.phani.data

import javax.inject.Inject

class DataRepoImpl @Inject constructor():DataRepository {
    override fun getProfile(): Profile {
         return Profile(name = "Phani",1)
    }

}