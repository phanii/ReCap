package com.phani.user.db

import com.phani.user.db.UserDao
import com.phani.user.model.User
import javax.inject.Inject

class UserRepo @Inject constructor(private val dao: UserDao) {
    suspend fun createUser(user: User): Long {
        return dao.insertUser(user)
    }
}