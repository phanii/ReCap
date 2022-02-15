package com.phani.user.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.phani.user.model.User
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [User::class], version = 1)
abstract class UserDb : RoomDatabase() {
    abstract fun getUserdao(): UserDao

    companion object {
        private var DB_INSTANCE: UserDb? = null

        fun getUserDBInstance(context: Context): UserDb {
            if (DB_INSTANCE == null) {
                DB_INSTANCE =
                    Room.databaseBuilder(
                        context.applicationContext,
                        UserDb::class.java, "USER_DB"
                    )
                        .allowMainThreadQueries().build()

            }
            Log.d("logging", "DB created!")
            return DB_INSTANCE as UserDb
        }

    }

}