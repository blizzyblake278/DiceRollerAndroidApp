package com.example.wheeler_blake_assign_8

import android.os.Parcelable
import android.widget.ImageView
import com.example.wheeler_blake_assign_8.R.*
import kotlinx.android.parcel.Parcelize

@Parcelize
class Dice(var _totalValue: Int, var _dieResult1: Int, var _dieResult2: Int, var _dieResult3: Int): Parcelable {

    fun rollDice(){
//        val num = (1..6).random()
        //returns random number for a D6 as Int.
        _dieResult1 = (1..6).random()
        _dieResult2 = (1..6).random()
        _dieResult3 = (1..6).random()
        _totalValue = _dieResult1 + _dieResult2 + _dieResult3





    }

    fun resetResults() {
        _dieResult1 = 0
        _dieResult2 = 0
        _dieResult3 = 0

    }




}