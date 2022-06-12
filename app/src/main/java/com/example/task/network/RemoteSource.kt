package com.example.task.network

import com.example.task.TaskResponse
import retrofit2.Response

interface RemoteSource {
   suspend fun getTask(): Response<TaskResponse>
}