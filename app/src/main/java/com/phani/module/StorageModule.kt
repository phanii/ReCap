package com.phani.module

import android.app.Application
import androidx.room.Room
import com.phani.preference.PreferenceImpl
import com.phani.preference.PreferenceStorage
import com.phani.user.db.UserDb
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.lang.Appendable
import javax.inject.Singleton
import javax.security.auth.callback.Callback

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {
    @Binds
    abstract fun bindPreferenceStorage(preferenceImpl: PreferenceImpl): PreferenceStorage

}