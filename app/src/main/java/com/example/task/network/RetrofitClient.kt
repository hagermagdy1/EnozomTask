package com.example.task.network

import android.util.Log
import com.example.task.TaskResponse
import retrofit2.Response

class RetrofitClient : RemoteSource {

        private val retrofitHelper =
            RetrofitHelper.getClient().create(RetrofitService::class.java)


        companion object {
            private var instance: RetrofitClient? = null
            fun getInstance(): RetrofitClient {
                return instance ?: RetrofitClient()
            }
        }
    override suspend fun getTask(): Response<TaskResponse>{
        val response = retrofitHelper.getTask()
        Log.i("TAG", "getTask: " + response.code())
        return response
    }



}