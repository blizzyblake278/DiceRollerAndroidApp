package com.example.wheeler_blake_assign_8

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.view.Menu
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.wheeler_blake_assign_8.Dice
import com.example.wheeler_blake_assign_8.R
import kotlinx.android.synthetic.main.activity_main.*
import android.view.MenuItem


class MainActivity : AppCompatActivity() {

    private var dice: Dice = Dice(0,0,0,0,0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sets dice images to 1,2,3
        dice.resetResults()

        _btnRoll.setOnClickListener {
            val animateSpin = AnimationUtils.loadAnimation(this, R.anim.spin)
            _btnRoll.startAnimation(animateSpin)
            dice.rollDice()
            setImages()
            totalScore()

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
        //restores data from functions
        dice = savedInstanceState.getParcelable<Dice>("myDice")!!
        setImages()
        totalScore()
        super.onRestoreInstanceState(savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return super.onCreateOptionsMenu(menu)
    }
    private fun setImages() {
        //sets 1st imageView to die roll based off dieResult1
        when (dice._dieResult1) {
            1 -> _iv1.setImageResource(R.drawable.die_1)
            2 -> _iv1.setImageResource(R.drawable.die_2)
            3 -> _iv1.setImageResource(R.drawable.die_3)
            4 -> _iv1.setImageResource(R.drawable.die_4)
            5 -> _iv1.setImageResource(R.drawable.die_5)
            else -> _iv1.setImageResource(R.drawable.die_6)

        }
        //sets 2nd imageView to die roll based off dieResult2
        when (dice._dieResult2) {
            1 -> _iv2.setImageResource(R.drawable.die_1)
            2 -> _iv2.setImageResource(R.drawable.die_2)
            3 -> _iv2.setImageResource(R.drawable.die_3)
            4 -> _iv2.setImageResource(R.drawable.die_4)
            5 -> _iv2.setImageResource(R.drawable.die_5)
            else -> _iv2.setImageResource(R.drawable.die_6)
        }
        //sets 3rd imageView to die roll based off dieResult3
        when (dice._dieResult3) {
            1 -> _iv3.setImageResource(R.drawable.die_1)
            2 -> _iv3.setImageResource(R.drawable.die_2)
            3 -> _iv3.setImageResource(R.drawable.die_3)
            4 -> _iv3.setImageResource(R.drawable.die_4)
            5 -> _iv3.setImageResource(R.drawable.die_5)
            else -> _iv3.setImageResource(R.drawable.die_6)
        }

    }


    private fun totalScore(){
        val doubleString: String = getString(R.string.enhance_double)
        val tripleString: String = getString(R.string.enhance_triple)
        val noEnhanceString: String = getString(R.string.enhance_none)
        var totalScoreString: String = getString(R.string.score_total)
        val scoreThisRoll = dice._totalValue.toString()
        totalScoreString += dice._totalScore
        when {
            dice._totalValue >= 100 -> {
                _enhancer.text = tripleString
            }
            dice._totalValue >= 50 -> {
                _enhancer.text = doubleString
            }
            else -> {
                _enhancer.text = noEnhanceString
            }
        }
        _totalScore.text = scoreThisRoll
        _Score.text = totalScoreString
    }

}






