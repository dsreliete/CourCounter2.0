package com.example.eliete.myarchitecturecomponents.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.eliete.myarchitecturecomponents.data.model.Team

/**
 * Created by eliete on 2/27/18.
 */
@Database(entities = arrayOf(Team::class), version = 1)
abstract class TeamRoomDatabase : RoomDatabase() {

    abstract fun teamDao() : TeamDao

}