package com.example.eliete.myarchitecturecomponents

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel : ScoreViewModel by lazy {
        ViewModelProviders.of(this).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            value -> scoreTeamA.text = value.toString()
        })

        viewModel.scoreTeamB.observe(this, Observer {
            score -> scoreTeamB.text = score.toString()
        })
    }
}
