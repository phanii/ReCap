package com.phani.module

import com.phani.data.DataRepoImpl
import com.phani.data.DataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class ProfileModule {

    @Binds
    abstract fun getProfileSource(repo: DataRepoImpl): DataRepository
}