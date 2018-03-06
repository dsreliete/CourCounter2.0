package com.example.eliete.myarchitecturecomponents.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.eliete.myarchitecturecomponents.R
import com.example.eliete.myarchitecturecomponents.TeamApplication
import com.example.eliete.myarchitecturecomponents.data.model.ToastMessage
import com.example.eliete.myarchitecturecomponents.data.model.TeamViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val viewModel: TeamViewModel by lazy {
        val applicationContext = this.applicationContext as TeamApplication
        val dependencies = applicationContext.getDependencies()
        val factory = dependencies.viewMoldelFactory

        ViewModelProviders.of(this, factory).get(TeamViewModel::class.java)
    }

    override fun onClick(view : View) {
        when(view.id) {
            btnReset.id -> viewModel.resetScoreTeam()
            btn3TeamA.id -> viewModel.updateTeamA(3)
            btn2TeamA.id -> viewModel.updateTeamA(2)
            btn1TeamA.id -> viewModel.updateTeamA(1)
            btn3TeamB.id -> viewModel.updateTeamB(3)
            btn2TeamB.id -> viewModel.updateTeamB(2)
            btn1TeamB.id -> viewModel.updateTeamB(1)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViewListeners()

        viewModel.message.observe(this, ToastMessage.ToastObserver {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.scoreTeamA.observe(this, Observer {
            scoreTeamA.text = it!!.score.toString()
        })

        viewModel.scoreTeamB.observe(this, Observer {
            scoreTeamB.text = it!!.score.toString()
        })
    }

    private fun setViewListeners() {
        btnReset.setOnClickListener(this)
        btn1TeamB.setOnClickListener(this)
        btn2TeamB.setOnClickListener(this)
        btn3TeamB.setOnClickListener(this)
        btn1TeamA.setOnClickListener(this)
        btn2TeamA.setOnClickListener(this)
        btn3TeamA.setOnClickListener(this)
    }
}
