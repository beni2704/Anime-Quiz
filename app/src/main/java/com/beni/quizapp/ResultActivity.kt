package com.beni.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private var tvName: TextView? = null
    private var tvScore: TextView? = null
    private var btnFinish: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvName = findViewById(R.id.tvUsername)
        tvScore = findViewById(R.id.tvScore)
        btnFinish = findViewById(R.id.btnFinish)

        tvName?.text = intent.getStringExtra(Constants.username)

        val totalQuestion = intent.getIntExtra(Constants.total_question,0)
        val corrAnswer = intent.getIntExtra(Constants.correct_answers,0)

        tvScore?.text = "Your Score is $corrAnswer out of $totalQuestion"

        btnFinish?.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}