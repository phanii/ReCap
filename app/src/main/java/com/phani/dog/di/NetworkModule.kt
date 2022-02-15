package com.phani.dog.di

import android.app.Application
import android.content.Context
import com.phani.dog.data.remote.DogService
import com.phani.dog.utils.Constants
import com.phani.user.db.UserDao
import com.phani.user.db.UserDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS).build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }


    @Singleton
    @Provides
    fun provideCurrencyService(retrofit: Retrofit): DogService =
        retrofit.create(DogService::class.java)


    @Singleton
    @Provides
    fun getAppDatabase(context: Application): UserDb {
        return UserDb.getUserDBInstance(context)
    }

    @Singleton
    @Provides
    fun getAppDao(userDb: UserDb): UserDao {
        return userDb.getUserdao()
    }

}