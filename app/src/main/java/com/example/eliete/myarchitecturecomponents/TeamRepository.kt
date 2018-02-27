package com.example.eliete.myarchitecturecomponents

import java.util.concurrent.Executor

/**
 * Created by eliete on 2/27/18.
 */
class TeamRepository internal constructor(private val teamDao: TeamDao,
                                          private val ioExecutor: Executor) : DataRepository {

    override fun insertScoreTeam(team: Team) {
        ioExecutor.execute({
            teamDao.insertTeam(team)
        })
    }

    override fun getScoreTeam(id: Int): Team? {
        return teamDao.getScoreTeam(id)
    }

    override fun updateTeam(team: Team) {
        return teamDao.updateTeam(team)
    }
}