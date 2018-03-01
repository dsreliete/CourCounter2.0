package com.example.eliete.myarchitecturecomponents.data

import com.example.eliete.myarchitecturecomponents.data.model.Team

/**
 * Created by eliete on 2/27/18.
 */
interface DataRepository {

    fun insertScoreTeam(team: Team)

    fun getScoreTeam(id: Int): Team?

    fun updateTeam(team: Team)

}