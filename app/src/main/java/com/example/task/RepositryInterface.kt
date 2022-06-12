package com.example.task

import retrofit2.Response

interface RepositryInterface {
    suspend fun getTask(): Response<TaskResponse>

}