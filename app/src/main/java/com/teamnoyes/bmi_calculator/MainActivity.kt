package com.teamnoyes.bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var tallEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        tallEditText = findViewById(R.id.tallEditText)
        weightEditText = findViewById(R.id.weightEditText)
        confirmButton = findViewById(R.id.confirmButton)

        initButton()
    }

    private fun initButton(){
        confirmButton.setOnClickListener {
            Log.d("MainActivity", "confirmButton is pushed")
            if (tallEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val tall = tallEditText.text.toString().toInt()
            val weight = weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("tall", tall)
            intent.putExtra("weight", weight)
            startActivity(intent)
        }
    }
}