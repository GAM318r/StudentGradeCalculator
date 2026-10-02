package com.example.studentgradecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val grade1 = findViewById<EditText>(R.id.grade1)
        val grade2 = findViewById<EditText>(R.id.grade2)
        val grade3 = findViewById<EditText>(R.id.grade3)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        calculateButton.setOnClickListener {
            val g1 = grade1.text.toString().toDoubleOrNull()
            val g2 = grade2.text.toString().toDoubleOrNull()
            val g3 = grade3.text.toString().toDoubleOrNull()

            if (g1 != null && g2 != null && g3 != null) {
                val average = (g1 + g2 + g3) / 3

                val letterGrade = when {
                    average >= 90 -> "A"
                    average >= 80 -> "B"
                    average >= 70 -> "C"
                    average >= 60 -> "D"
                    else -> "F"
                }

                resultText.text = "Average: %.1f%%\nLetter Grade: %s".format(
                    average,
                    letterGrade
                )
            } else {
                resultText.text = "Please enter all three grades."
            }
        }
    }
}