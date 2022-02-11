package com.phani.dog.data

import com.phani.dog.model.BaseApiResponse
import com.phani.dog.model.DogResponse
import com.phani.dog.data.remote.RemoteDataSource
import com.phani.dog.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    BaseApiResponse() {
    suspend fun getDog(): Flow<NetworkResult<DogResponse>> {
        return flow {
            emit(safeApiCall { remoteDataSource.getDog() })
        }.flowOn(Dispatchers.IO)
    }
}