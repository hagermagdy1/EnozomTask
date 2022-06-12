package com.example.task

import android.content.Context
import android.util.Log
import com.example.task.network.RemoteSource
import com.example.task.network.RetrofitClient
import retrofit2.Response

    class Repository private constructor(
        var remoteSource: RemoteSource,
        var context: Context
    ) : RepositryInterface {
        companion object {
            private var instance: Repository? = null
            fun getInstance(
                remoteSource: RetrofitClient, context: Context
            ): Repository {
                return instance ?: Repository(remoteSource, context)
            }
        }
        override suspend fun getTask(): Response<TaskResponse> {
            Log.i("TAG", "getTask: " +  remoteSource.getTask())
            return remoteSource.getTask()

        }

    }
