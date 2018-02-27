package com.example.eliete.myarchitecturecomponents

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val applicationContext = this.applicationContext as TeamApplication
        val dependencies = applicationContext.getDependencies()
        val factory = dependencies.viewMoldelFactory

        val viewModel = ViewModelProviders.of(this, factory).get(TeamViewModel::class.java)

        btnReset.setOnClickListener {
            viewModel.resetScoreTeam()
        }

        btn3TeamA.setOnClickListener {
            viewModel.updateTeamA(3)
        }

        btn2TeamA.setOnClickListener {
            viewModel.updateTeamA(2)
        }

        btn1TeamA.setOnClickListener{
            viewModel.updateTeamA(1)
        }

        btn3TeamB.setOnClickListener {
            viewModel.updateTeamB(3)
        }

        btn2TeamB.setOnClickListener {
            viewModel.updateTeamB(2)
        }

        btn1TeamB.setOnClickListener {
            viewModel.updateTeamB(1)
        }

        viewModel.scoreTeamA.observe(this, Observer {
            value -> scoreTeamA.text = value!!.score.toString()
        })

        viewModel.scoreTeamB.observe(this, Observer {
            value -> scoreTeamB.text = value!!.score.toString()
        })
    }
}
