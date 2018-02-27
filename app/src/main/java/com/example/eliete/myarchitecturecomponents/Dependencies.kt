package com.example.eliete.myarchitecturecomponents

import android.arch.persistence.room.Room
import android.content.Context
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Created by eliete on 2/27/18.
 */
class Dependencies(private val context : Context) {

    private val wordRepository : DataRepository by lazy {
        TeamRepository(roomDatabase.teamDao(), IOExecutor)
    }

    private val roomDatabase : TeamRoomDatabase by lazy {
        Room.databaseBuilder(context.applicationContext,
                TeamRoomDatabase::class.java, "score_database")
                .build()
    }

    private val IOExecutor : ExecutorService by lazy {
        Executors.newSingleThreadExecutor()
    }

    val viewMoldelFactory : TeamViewModelFactory by lazy {
        TeamViewModelFactory(wordRepository)
    }
}