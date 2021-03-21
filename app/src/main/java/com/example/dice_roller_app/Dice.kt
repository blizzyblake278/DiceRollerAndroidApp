package com.example.dice_roller_app

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Dice(var _totalValue: Int, var _dieResult1: Int, var _dieResult2: Int, var _dieResult3: Int, var _totalScore : Int): Parcelable {

    fun rollDice(){
//        val num = (1..6).random()
        //returns random number for a D6 as Int.
        _dieResult1 = (1..6).random()
        _dieResult2 = (1..6).random()
        _dieResult3 = (1..6).random()
        _totalValue = _dieResult1 + _dieResult2 + _dieResult3


        // if triples then total value + 100
           if(_dieResult1 == _dieResult2 && _dieResult2 == _dieResult3){
               _totalValue += 100
            }
            //if doubles rolled, then total value + 50
            else if(_dieResult1 == _dieResult2 || _dieResult2 == _dieResult3 || _dieResult1 == _dieResult3){
                    _totalValue += 50
            }
        else{
            _totalValue
        }
        //total of all rolls
        _totalScore += _totalValue
    }

    fun resetResults() {
        _dieResult1 = 0
        _dieResult2 = 0
        _dieResult3 = 0

    }




}