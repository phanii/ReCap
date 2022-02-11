package com.phani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.phani.databinding.ActivityMainBinding
import com.phani.dog.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewmodel by viewModels<MainViewModel>()


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchData()
    }


    private fun fetchData() {
        println("fetchdata")
        fetchResponse()
        viewmodel.response.observe(this)
        { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {
                        println("Success ${it.message}  and ${response.data}")
                    }
                }

                is NetworkResult.Error -> {
                    println("Error ${response.message}")
                }

                is NetworkResult.Loading -> {
                    println("Loading..")
                }
            }
        }
    }

    private fun fetchResponse() {
        viewmodel.fetchDogResponse()
    }
}