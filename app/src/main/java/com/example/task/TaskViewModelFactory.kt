package com.example.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException


    class TaskViewModelFactory(private val _irepo: RepositryInterface) :
        ViewModelProvider.Factory  {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(TaskViewModel::class.java)){
                TaskViewModel(_irepo) as T
            }
            else{
                throw IllegalArgumentException("View Model Class Not Found")
            }
        }
    }
