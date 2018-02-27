package com.example.eliete.myarchitecturecomponents

import android.app.Application

/**
 * Created by eliete on 2/27/18.
 */
class TeamApplication : Application() {

    private lateinit var dependencies: Dependencies

    override fun onCreate() {
        super.onCreate()

        dependencies = Dependencies(this)
    }

    fun getDependencies() = dependencies
}