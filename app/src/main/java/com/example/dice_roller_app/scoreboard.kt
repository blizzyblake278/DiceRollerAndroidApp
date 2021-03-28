package com.example.dice_roller_app

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.BundleCompat
import kotlinx.android.synthetic.main.scoreboard.*

class Scoreboard: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        val bundle : Bundle? = intent.extras
        val playerName : String? = intent.getStringExtra("playerName")
        val score = intent.getSerializableExtra("key") as ArrayList<*>

        super.onCreate(savedInstanceState)
        setContentView(R.layout.scoreboard)

        val playerStatsTV : TextView = findViewById(R.id._playerStatsTV)
        playerStatsTV.text = playerName
//
//        val scoreTV : TextView = findViewById(R.id._Score)
//        scoreTV.text = score[0].toString()


        val sharedPreference : SharedPreferences = getSharedPreferences("DICE_ROLLER_APP", Context.MODE_PRIVATE)
        var toastMessage : String? = sharedPreference.getString("username", null)
        Toast.makeText(this@Scoreboard, toastMessage, Toast.LENGTH_SHORT).show()
    }

}