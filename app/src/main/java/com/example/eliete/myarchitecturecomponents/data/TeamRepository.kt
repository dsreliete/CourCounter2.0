package com.example.eliete.myarchitecturecomponents.data

import com.example.eliete.myarchitecturecomponents.data.DataRepository
import com.example.eliete.myarchitecturecomponents.data.model.Team
import com.example.eliete.myarchitecturecomponents.data.db.TeamDao
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
        var team : Team? = null
        ioExecutor.execute({
            team = teamDao.getScoreTeam(id)
        })
        return team
    }

    override fun updateTeam(team: Team) {
        ioExecutor.execute({
            teamDao.updateTeam(team)
        })
    }
}