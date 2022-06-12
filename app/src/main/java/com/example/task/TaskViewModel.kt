package com.example.task

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



    class TaskViewModel(iRepo: RepositryInterface) : ViewModel() {
        private val _iRepo: RepositryInterface = iRepo

        private var _task = MutableLiveData<TaskResponse>()
        var task: LiveData<TaskResponse> = _task

        fun getAllTask() {
            viewModelScope.launch {
                var tasks: TaskResponse? = null
                val taskResponse = _iRepo.getTask()
                if (taskResponse.code() == 200) {
                    tasks = taskResponse.body()
                }

                withContext(Dispatchers.Main) {
                    _task.postValue(tasks!!)
                    Log.i("TAG", "getTask--------------------->: $tasks")
                }
            }
        }
}