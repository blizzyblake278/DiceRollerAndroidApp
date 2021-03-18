package com.example.wheeler_blake_assign_8

import android.media.Image
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.wheeler_blake_assign_8.Dice
import com.example.wheeler_blake_assign_8.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //1st edition
    //private var dice: Dice = Dice(0)
    //trying something new to store data in class
    private var dice: Dice = Dice(0,0,0,0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        _txtDieResult1.text = dice._dieResult1.toString()
//        _txtDieResult2.text = dice._dieResult2.toString()
//        _txtDieResult3.text = dice._dieResult3.toString()
        dice.resetResults()



        _btnRoll.setOnClickListener {
            val animateSpin = AnimationUtils.loadAnimation(this, R.anim.spin)
            _btnRoll.startAnimation(animateSpin)
            dice.rollDice()
//            _txtDieResult1.text = dice._dieResult1.toString()
//            _txtDieResult2.text = dice._dieResult2.toString()
//            _txtDieResult3.text = dice._dieResult3.toString()
//

           when(dice._dieResult1){
                1 -> _iv1.setImageResource(R.drawable.die_1)
                2 ->_iv1.setImageResource(R.drawable.die_2)
                3 -> _iv1.setImageResource(R.drawable.die_3)
                4 -> _iv1.setImageResource(R.drawable.die_4)
                5 -> _iv1.setImageResource(R.drawable.die_5)
                else -> _iv1.setImageResource(R.drawable.die_6)
            }
            when(dice._dieResult2){
                1 -> _iv2.setImageResource(R.drawable.die_1)
                2 ->_iv2.setImageResource(R.drawable.die_2)
                3 -> _iv2.setImageResource(R.drawable.die_3)
                4 -> _iv2.setImageResource(R.drawable.die_4)
                5 -> _iv2.setImageResource(R.drawable.die_5)
                else -> _iv2.setImageResource(R.drawable.die_6)
            }
           when(dice._dieResult3){
               1 -> _iv3.setImageResource(R.drawable.die_1)
               2 ->_iv3.setImageResource(R.drawable.die_2)
               3 -> _iv3.setImageResource(R.drawable.die_3)
               4 -> _iv3.setImageResource(R.drawable.die_4)
               5 -> _iv3.setImageResource(R.drawable.die_5)
               else -> _iv3.setImageResource(R.drawable.die_6)
           }

            _totalScore.text = dice._totalValue.toString()


        }




    }
    @Override
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        //Saves current game state
        savedInstanceState.putParcelable("myDice", dice)
        super.onSaveInstanceState(savedInstanceState)
    }

    //2nd go at this
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        dice = savedInstanceState.getParcelable<Dice>("myDice")!!
//        _txtDieResult1.text = dice._dieResult1.toString()
//        _txtDieResult2.text = dice._dieResult2.toString()
//        _txtDieResult3.text = dice._dieResult3.toString()
        _iv1
        _iv2
        _iv3

        _totalScore.text = dice._totalValue.toString()

        super.onRestoreInstanceState(savedInstanceState)

    }
}






