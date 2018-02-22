package com.example.eliete.myarchitecturecomponents

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Looper
import android.util.Log

/**
 * Created by eliete on 2/22/18.
 */
class ScoreViewModel : ViewModel() {

    var scoreTeamA = MutableLiveData<Int>().apply{
        value = 0
    }

    var scoreTeamB = MutableLiveData<Int>().apply{
        value = 0
    }

    fun updateTeamA(value : Int) {
        updateScore(scoreTeamA, value)
    }

    fun updateTeamB(value : Int) {
        updateScore(scoreTeamB, value)
    }

    fun resetScoreTeam() {
        scoreTeamA.postValue(0)
        scoreTeamB.postValue(0)
    }

    private fun updateScore(score : MutableLiveData<Int>, value : Int) {
        Log.d("Looper", Looper.myLooper().toString())
        score.postValue(score.value?.plus(value))
    }
}