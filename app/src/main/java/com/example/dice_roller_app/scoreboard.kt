package com.example.dice_roller_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Scoreboard: AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?){
        val bundle : Bundle? = intent.extras
        val playerName : String? = intent.getStringExtra("playerName")
        val highScore : String? = intent.getStringExtra("playerScore")
//        val score = intent.getSerializableExtra("key") as ArrayList<*>

        super.onCreate(savedInstanceState)
        setContentView(R.layout.scoreboard)

        val playerStatsTV : TextView = findViewById(R.id._playerStatsTV)
        val addColon : String = getString(R.string.addColon)

        playerStatsTV.text = playerName + addColon + highScore



//        val sharedPreference : SharedPreferences = getSharedPreferences("DICE_ROLLER_APP", Context.MODE_PRIVATE)

    }

}