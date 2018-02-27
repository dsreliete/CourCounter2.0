package com.example.eliete.myarchitecturecomponents

import android.arch.persistence.room.*

/**
 * Created by eliete on 2/27/18.
 */
@Dao
interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeam(team : Team)

    @Update
    fun updateTeam(team : Team)

    @Query("SELECT * FROM Team WHERE id =" +  " :id")
    fun getScoreTeam(id : Int) : Team?
}