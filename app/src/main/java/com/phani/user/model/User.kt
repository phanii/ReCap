package com.phani.user.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(@PrimaryKey(autoGenerate = true) @NonNull val id:Long?=null,val name:String?=null, val age:Int?=null)
