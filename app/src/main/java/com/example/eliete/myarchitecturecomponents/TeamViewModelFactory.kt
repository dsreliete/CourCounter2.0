package com.example.eliete.myarchitecturecomponents

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import java.util.concurrent.ExecutorService

/**
 * Created by eliete on 2/27/18.
 */
class TeamViewModelFactory(private val scoreRepository: DataRepository,
                           private val ioExecutor: ExecutorService) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TeamViewModel(scoreRepository, ioExecutor) as T
    }
}