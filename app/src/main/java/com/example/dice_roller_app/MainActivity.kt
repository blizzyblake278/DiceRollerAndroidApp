package com.example.dice_roller_app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    private var dice: Dice = Dice(0,0,0,0,0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sets dice images to 1,2,3
        dice.resetResults()

        //roll dice
        _btnRoll.setOnClickListener {
            val animateSpin = AnimationUtils.loadAnimation(this, R.anim.spin)
            _btnRoll.startAnimation(animateSpin)
            dice.rollDice()
            setImages()
            totalScore()

        }

        //leader board
//        _secondActBtn.setOnClickListener(){
//            val scoreBoardintent = Intent(this, SecondAct::class.java)
//            intent.putExtra("personName", _personNameTxt.text.toString())
//            intent.putExtra("key", score)
//            startActivity(ScoreBoardintent)
//
//        }
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
    R.id.About -> {
        val name = getString(R.string.name)
        val descr = getString(R.string.game_description)
        val estDate = getString(R.string.est_date)
        val builder =  AlertDialog.Builder(this)
        builder.setTitle(R.string._about)
        builder.setMessage(name + descr + estDate)
        val alertDialog : AlertDialog = builder.create()
        alertDialog.show()
        true
    }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }


    // Private Functions
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






