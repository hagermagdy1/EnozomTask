package com.example.task.network

import com.example.task.TaskResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitService {
    @Headers(
        "x-api-key: BC_a9950c194903488c9c0540808c51739d_1BIbjEGmoLfyLDMEqkAlLyYwwgsAe1/E+0bodj/Dg+A=")
        @GET("GetMyTask")
        suspend fun getTask(): Response<TaskResponse>

}