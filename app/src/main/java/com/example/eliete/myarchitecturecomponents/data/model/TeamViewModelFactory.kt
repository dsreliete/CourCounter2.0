package com.example.eliete.myarchitecturecomponents.data.model

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.eliete.myarchitecturecomponents.data.DataRepository

/**
 * Created by eliete on 2/27/18.
 */
class TeamViewModelFactory(private val scoreRepository: DataRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TeamViewModel(scoreRepository) as T
    }
}