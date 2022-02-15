package com.phani

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.phani.databinding.ActivityMainBinding
import com.phani.dog.utils.NetworkResult
import com.phani.dog.utils.Utils
import com.phani.user.model.User
import com.phani.user.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewmodel by viewModels<MainViewModel>()
    private val viewmodel_storage by viewModels<DataStoreViewModel>()
    private val userViewModel by viewModels<UserViewModel>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel_storage.setSavedKey(key = true)

        userViewModel.insertUser(User(id = 1, name = "User 1", age = 12))
        // fetchData()
        fetchUser()
    }

    private fun fetchUser() {

        userViewModel.response.observe(this)
        {
            println("User id $it")
        }
    }

    private fun fetchData() {

        viewmodel_storage.savedKey.observe(this)
        {
            println("SavedKey $it")
        }
         fetchResponse()
        viewmodel.response.observe(this)
        { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {
                        println("Success ${it.message}  and ${response.data}")
                        binding.pbDog.visibility=View.GONE
                    }
                }

                is NetworkResult.Error -> {

                    println("Error ${response.message}")
                    binding.pbDog.visibility=View.GONE
                }

                is NetworkResult.Loading -> {
                    binding.pbDog.visibility=View.VISIBLE
                    Toast.makeText(this,"loading...",Toast.LENGTH_SHORT).show()
                    println("Loading..")
                }
            }
        }
    }

     private fun fetchResponse() {
         binding.pbDog.visibility=View.VISIBLE
             viewmodel.fetchDogResponse()
    }
}