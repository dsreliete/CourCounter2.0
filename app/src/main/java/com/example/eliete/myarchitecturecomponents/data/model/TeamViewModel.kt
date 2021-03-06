package com.example.eliete.myarchitecturecomponents.data.model

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.eliete.myarchitecturecomponents.data.DataRepository

/**
 * Created by eliete on 2/22/18.
 */
class TeamViewModel(private val teamRepository: DataRepository) : ViewModel() {

    private var teamA : Team? = getTeamScore(1)
    private var teamB : Team? = getTeamScore(2)
    val scoreTeamA : MutableLiveData<Team> = MutableLiveData()
    val scoreTeamB : MutableLiveData<Team> = MutableLiveData()
    val message : ToastMessage = ToastMessage()

    init {
        if (teamA == null) {
            initializeTeamA()
        }

        if (teamB == null) {
            initializeTeamB()
        }
    }

    fun updateTeamA(value : Int) {
        teamA?.let {
            val newScore = it.copy(score = it.score + value)
            scoreTeamA.setValue(newScore)
            updateScore(newScore)
            teamA = newScore
        }
    }

    fun updateTeamB(value : Int) {
        teamB?.let {
            val newScore = it.copy(score = it.score + value)
            scoreTeamB.setValue(newScore)
            updateScore(newScore)
            teamB = newScore
        }
    }

    fun resetScoreTeam() {
        initializeTeamA()
        initializeTeamB()
        message.setValue("reseted Team score")
    }

    private fun initializeTeamA() {
        teamA = Team(1, 0)
        scoreTeamA.setValue(teamA)
        saveScore(teamA!!)
    }

    private fun initializeTeamB() {
        teamB = Team(2, 0)
        scoreTeamB.setValue(teamB)
        saveScore(teamB!!)
    }

    private fun saveScore(team : Team) {
        teamRepository.insertScoreTeam(team)
    }

    private fun updateScore(team : Team) {
        teamRepository.updateTeam(team)
        message.setValue("updated Team score")
    }

    private fun getTeamScore(id : Int) : Team? {
        return teamRepository.getScoreTeam(id)
    }
}