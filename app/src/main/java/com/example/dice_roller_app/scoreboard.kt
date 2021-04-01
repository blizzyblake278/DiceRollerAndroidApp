package com.example.dice_roller_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.scoreboard.*
import org.w3c.dom.Text
import java.util.ArrayList


class Scoreboard: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val addColon : String = getString(R.string.addColon)
        val bundle : Bundle? = intent.extras
        val playerName : String? = intent.getStringExtra("playerName")
        val highScore : String? = intent.getStringExtra("playerScore")
        setContentView(R.layout.scoreboard)
        val scoreListView = findViewById<ListView>(R.id._scoreListView)
        val array = arrayOf(playerName + addColon + highScore)

       //instantiates arrayAdapter
        val adapter = ArrayAdapter(this,R.layout.row_list, array)
        scoreListView.adapter = adapter

        val thanksForPlayingtv  : TextView = findViewById(R.id._thanksForPlaying)
        val thanksString : String = getString(R.string.thanks_for_playing)
        thanksForPlayingtv.text = thanksString.plus(playerName)



      _returnToGameBtn.setOnClickListener{
//          finishActivity(101)
//          val mainActivity = Intent(this, MainActivity::class.java)
//          startActivityForResult(mainActivity, 101)

          this.finish()
      }

    }


}







