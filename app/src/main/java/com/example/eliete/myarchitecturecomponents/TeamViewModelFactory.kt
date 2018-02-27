package com.example.eliete.myarchitecturecomponents

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by eliete on 2/27/18.
 */
class TeamViewModelFactory(private val scoreRepository: DataRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TeamViewModel(scoreRepository) as T
    }
}