package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

private const val TAG = "MainActivity"

// Teste Debug
fun logging() {
    Log.e(TAG, "ERROR: a serious error like an app crash")
    Log.w(TAG, "WARN: warns about the potential for serious errors")
    Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
    Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
    Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
    Log.wtf(TAG, "WTF")
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val rollButton = findViewById<Button>(R.id.button)
        val dado = Dice(6)

        val rollButton: Button = findViewById(R.id.button)
        val imageView: ImageView = findViewById(R.id.imageView)
        rollButton.setOnClickListener { rollDice(dado, imageView) }
        rollDice(dado, imageView)

        logging()
    }

    private fun rollDice(dado: Dice, imageView: ImageView) {
        Toast.makeText(this, "Dado lançado!", Toast.LENGTH_SHORT).show()
        val diceRoll = dado.roll()
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        imageView.setImageResource(drawableResource)
        imageView.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}