package com.example.eliete.myarchitecturecomponents

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by eliete on 2/27/18.
 */
@Entity(tableName = "Team")
data class Team(@PrimaryKey val id : Int, val score : Int )