package com.example.dice_roller_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.scoreboard.*
import java.util.ArrayList


class Scoreboard: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val bundle : Bundle? = intent.extras
        val strPlayerName : String? = intent.getStringExtra("currentPlayer")
        val addColon : String = getString(R.string.addColon)
        val sharedPreference : SharedPreferences = getSharedPreferences("DICE_ROLLER_APP", Context.MODE_PRIVATE)
        val playerName = sharedPreference.getString("playerName", null)
        val playerScore = sharedPreference.getString("playerScore", null)

        val scoreList : ArrayList<String> = ArrayList()
        val myMap : Map<String, String> = sharedPreference.all as Map<String, String>
            for((key, value) in myMap) {
                scoreList.add("$key $addColon $value")
//                Log.d("MapTest", "$key $value")
            }

        setContentView(R.layout.scoreboard)
        val scoreListView = findViewById<ListView>(R.id._scoreListView)

//        instantiates arrayAdapter
        val adapter = ArrayAdapter(this,R.layout.row_list,scoreList)
        scoreListView.adapter = adapter

        val thanksForPlayingtv  : TextView = findViewById(R.id._thanksForPlaying)
        var thanksString : String = getString(R.string.thanks_for_playing)
        thanksString += strPlayerName
        thanksForPlayingtv.text = thanksString



        _returnToGameBtn.setOnClickListener{

            //returns to main and resets fields
            val mainIntent = Intent(this, MainActivity::class.java)
            this.finish()
            startActivity(mainIntent)
        }

    }


}







