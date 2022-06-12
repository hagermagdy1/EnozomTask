package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.task.network.RetrofitClient
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var taskFactory: TaskViewModelFactory

    private lateinit var viewModel: TaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        taskFactory = TaskViewModelFactory(
            Repository.getInstance(
                RetrofitClient.getInstance(),
                this
            )
        )
        viewModel = ViewModelProvider(this, taskFactory).get(TaskViewModel::class.java)
        viewModel.getAllTask()
        viewModel.task.observe(this) {
            if (it != null) {
                Log.i("TAG", "taskMainActivity: $it")

                var index = it.Indcies.split(",")
                var password = StringBuilder()
                for (i in index) {
                    password.append(it.Text.get(i.toInt()))
                }
                Log.i("TAG", "onCreate: " + password)
            }
        }
    }

}