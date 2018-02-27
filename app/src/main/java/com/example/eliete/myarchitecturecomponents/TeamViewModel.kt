package com.example.eliete.myarchitecturecomponents

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import java.util.concurrent.Executor

/**
 * Created by eliete on 2/22/18.
 */
class TeamViewModel(private val teamRepository: DataRepository, private val ioExecutor: Executor) : ViewModel() {

    private var teamA : Team? = getTeamScore(1)
    private var teamB : Team? = getTeamScore(2)
    val scoreTeamA : MutableLiveData<Team> = MutableLiveData()
    val scoreTeamB : MutableLiveData<Team> = MutableLiveData()

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
            scoreTeamA.postValue(newScore)
            updateScore(newScore)
            teamA = newScore
        }
    }

    fun updateTeamB(value : Int) {
        teamB?.let {
            val newScore = it.copy(score = it.score + value)
            scoreTeamB.postValue(newScore)
            updateScore(newScore)
            teamB = newScore
        }
    }

    fun resetScoreTeam() {
        initializeTeamA()
        initializeTeamB()
    }

    private fun initializeTeamA() {
        teamA = Team(1, 0)
        scoreTeamA.postValue(teamA)
        setScore(teamA!!)
    }

    private fun initializeTeamB() {
        teamB = Team(2, 0)
        scoreTeamB.postValue(teamB)
        setScore(teamB!!)
    }

    private fun setScore(team : Team) {
        ioExecutor.execute({
            teamRepository.insertScoreTeam(team)
        })
    }

    private fun updateScore(team : Team) {
        ioExecutor.execute({
            teamRepository.updateTeam(team)
        })
    }

    private fun getTeamScore(id : Int) : Team? {
        var team : Team? = null
        ioExecutor.execute({
            team = teamRepository.getScoreTeam(id)
        })
        return team
    }
}