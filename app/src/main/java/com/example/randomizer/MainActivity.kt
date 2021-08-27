package com.example.randomizer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Define all variable
        var i = 0
        var number = 1
        var text: TextView
        val iB: ImageView = findViewById(R.id.informationButton)
        val a1: Button = findViewById(R.id.add_one)
        val a10: Button = findViewById(R.id.add_10)
        val s1: Button = findViewById(R.id.supp_one)
        val s10: Button = findViewById(R.id.supp_10)
        val go1: Button = findViewById(R.id.go0)
        val go6: Button = findViewById(R.id.go6)
        val go12: Button = findViewById(R.id.go12)
        val go20: Button = findViewById(R.id.go20)
        val rollButton: Button = findViewById(R.id.Roll_button)

        // Function Check If Number <1 and >99
        fun checkNegate(number: Int): Int {
            if (number < 1)
                return 1
            if (number > 99)
                return 2
            return 0
        }

        // Function Roll Dice
        fun rollDice(number: Int) {
            val rollNumber = (1..number).random()
            val resultTextView: TextView = findViewById(R.id.Final_number)
            resultTextView.text = rollNumber.toString()
        }

        // Information Button
        iB.setOnClickListener {
            text = findViewById(R.id.informationText)
            if (i == 0) {
                text.text = "Please choose a \"number of faces\" and then click on \"Roll\" to get a random number of the chosen number"
                text.setBackgroundColor(-16777216)
                i++
            }
            else {
                text.text = ""
                text.setBackgroundColor(0)
                i--
            }
        }

        // Button add one
        a1.setOnClickListener {
            text = findViewById(R.id.number_of_faces)
            number++
            if (checkNegate(number) == 0)
                text.text = number.toString()
            else
                number--
        }

        // Button add ten
        a10.setOnClickListener {
            text = findViewById(R.id.number_of_faces)
            number += 10
            if (checkNegate(number) == 0)
                text.text = number.toString()
            else
                number -= 10
        }

        // Button supp one
        s1.setOnClickListener {
            text = findViewById(R.id.number_of_faces)
            number--
            if (checkNegate(number) == 0)
                text.text = number.toString()
            else
                number++
        }

        // Button supp ten
        s10.setOnClickListener {
            text = findViewById(R.id.number_of_faces)
            number -= 10
            if (checkNegate(number) == 0)
                text.text = number.toString()
            else
                number += 10
        }

        // Go one
        go1.setOnClickListener {
            number = 1
            text = findViewById(R.id.number_of_faces)
            text.text = number.toString()
        }

        // Go six
        go6.setOnClickListener {
            number = 6
            text = findViewById(R.id.number_of_faces)
            text.text = number.toString()
        }

        // Go twelve
        go12.setOnClickListener {
            number = 12
            text = findViewById(R.id.number_of_faces)
            text.text = number.toString()
        }

        // Go twenty
        go20.setOnClickListener {
            number = 20
            text = findViewById(R.id.number_of_faces)
            text.text = number.toString()
        }

        // Roll
        rollButton.setOnClickListener {
            rollDice(number)
        }
    }
}