package com.phani.user.di

import android.app.Application
import android.content.Context
import com.phani.user.db.UserDao
import com.phani.user.db.UserDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun getAppDatabase(context: Application):UserDb
    {
        return UserDb.getUserDBInstance(context)
    }
    @Singleton
    @Provides
    fun getAppDao(userDb: UserDb):UserDao
    {
        return userDb.getUserdao()
    }

}