package com.teamnoyes.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    private lateinit var bmiTextView: TextView
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        init()
    }

    private fun init(){
        bmiTextView = findViewById(R.id.bmiText)
        resultTextView = findViewById(R.id.resultText)

        calcBMI()
    }

    private fun calcBMI(){
        val tall = intent.getIntExtra("tall", 0)
        val weight = intent.getIntExtra("weight", 0)

        val bmi = tall / (weight / 100.0).pow(2.0)

        val resultText = when{
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        bmiTextView.text = bmi.toString()
        resultTextView.text = resultText.toString()
    }
}