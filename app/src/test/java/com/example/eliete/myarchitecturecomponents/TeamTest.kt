package com.example.eliete.myarchitecturecomponents

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by eliete on 2/27/18.
 */
class TeamTest {

    @JvmField
    @Rule
    val testingRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun verifyScoreTeamInitialization() {

        val teamA = Team(1,0)
        val teamB = Team(2,0)

        val repository = Mockito.mock(DataRepository::class.java).apply {
            Mockito.`when`(getScoreTeam(1)).then {
                null
            }

            Mockito.`when`(getScoreTeam(2)).then {
                null
            }
        }

        val viewModel = TeamViewModel(repository)
        val observer: Observer<Team> = Mockito.mock(Observer::class.java) as Observer<Team>

        viewModel.scoreTeamA.observeForever(observer)
        viewModel.scoreTeamB.observeForever(observer)

        Mockito.verify(observer).onChanged(teamA)
        Mockito.verify(observer).onChanged(teamB)
    }

    @Test
    fun verifyScoreTeamA_afterInsert3Points() {
        val teamA = Team(1,3)

        val repository = Mockito.mock(DataRepository::class.java).apply {
            Mockito.`when`(getScoreTeam(1)).then {
                Team(1,0)
            }
        }

        val viewModel = TeamViewModel(repository)
        viewModel.updateTeamA(3)

        val observer: Observer<Team> = Mockito.mock(Observer::class.java) as Observer<Team>

        viewModel.scoreTeamA.observeForever(observer)

        Mockito.verify(observer).onChanged(teamA)
    }

    @Test
    fun verifyScoreTeamB_afterInsert2Points() {
        val teamB = Team(2,2)

        val repository = Mockito.mock(DataRepository::class.java).apply {
            Mockito.`when`(getScoreTeam(2)).then {
                Team(2,0)
            }
        }

        val viewModel = TeamViewModel(repository)
        viewModel.updateTeamB(2)

        val observer: Observer<Team> = Mockito.mock(Observer::class.java) as Observer<Team>

        viewModel.scoreTeamB.observeForever(observer)

        Mockito.verify(observer).onChanged(teamB)
    }

    @Test
    fun verifyScoreTeamA_afterInsertSecondPoint() {
        val teamA = Team(1,5)

        val repository = Mockito.mock(DataRepository::class.java).apply {
            Mockito.`when`(getScoreTeam(1)).then {
                Team(1,0)
            }
        }

        val viewModel = TeamViewModel(repository)
        viewModel.updateTeamA(3)
        viewModel.updateTeamA(2)

        val observer: Observer<Team> = Mockito.mock(Observer::class.java) as Observer<Team>

        viewModel.scoreTeamA.observeForever(observer)

        Mockito.verify(observer).onChanged(teamA)
    }

    @Test
    fun verifyScoreTeamB_afterInsertSecondPoint() {
        val teamB = Team(2,4)

        val repository = Mockito.mock(DataRepository::class.java).apply {
            Mockito.`when`(getScoreTeam(2)).then {
                Team(2,0)
            }
        }

        val viewModel = TeamViewModel(repository)
        viewModel.updateTeamB(3)
        viewModel.updateTeamB(1)

        val observer: Observer<Team> = Mockito.mock(Observer::class.java) as Observer<Team>

        viewModel.scoreTeamB.observeForever(observer)

        Mockito.verify(observer).onChanged(teamB)
    }

    @Test
    fun verifyResetScore() {
        val teamA = Team(1,0)
        val teamB = Team(2,0)

        val repository = Mockito.mock(DataRepository::class.java).apply {
            Mockito.`when`(getScoreTeam(1)).then {
                Team(1,52)
            }

            Mockito.`when`(getScoreTeam(2)).then {
                Team(2,78)
            }
        }

        val viewModel = TeamViewModel(repository)
        viewModel.resetScoreTeam()
        val observer: Observer<Team> = Mockito.mock(Observer::class.java) as Observer<Team>

        viewModel.scoreTeamA.observeForever(observer)
        viewModel.scoreTeamB.observeForever(observer)

        Mockito.verify(observer).onChanged(teamA)
        Mockito.verify(observer).onChanged(teamB)


    }

}