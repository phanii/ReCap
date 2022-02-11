package com.phani.dog.data.remote

import com.phani.dog.model.DogResponse
import com.phani.dog.utils.Constants.Companion.RANDOM_URL
import com.phani.dog.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface DogService {

    @GET(RANDOM_URL)
    suspend fun getDog(): Response<DogResponse>
}