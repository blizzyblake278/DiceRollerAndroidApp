package com.example.dice_roller_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.BundleCompat

class Scoreboard: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        val bundle : Bundle? = intent.extras
        val personName : String? = intent.getStringExtra("personName")
        val score = intent.getSerializableExtra("key") as ArrayList<*>
    }

}