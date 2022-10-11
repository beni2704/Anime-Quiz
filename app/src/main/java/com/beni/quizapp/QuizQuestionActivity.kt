package com.beni.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mUsername:String? = null

    private var mCurr: Int = 1
    private var mCorr: Int = 0
    private var mQuestionList:ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOptionOne:TextView? = null
    private var tvOptionTwo:TextView? = null
    private var tvOptionThree:TextView? = null
    private var tvOptionFour:TextView? = null

    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUsername = intent.getStringExtra(Constants.username)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)

        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)

        btnSubmit = findViewById(R.id.btnSubmit)
        mQuestionList = Constants.getQuestion()

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionView()
//        Log.i("QuestionList size is", "${questionList.size}")
//
//        for (question in questionList) {
//            Log.e("Questions", question.question)
//        }
        val question: Question = mQuestionList!![mCurr - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurr
        tvProgress?.text = "$mCurr / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if(mCurr == mQuestionList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#000000"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,R.drawable.selected_option_bg
        )
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.option_border_bg
            )
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tvOptionOne -> {
                tvOptionOne?.let{
                    selectedOptionView(it, 1)
                }
            }

            R.id.tvOptionTwo -> {
                tvOptionTwo?.let{
                    selectedOptionView(it, 2)
                }
            }

            R.id.tvOptionThree -> {
                tvOptionThree?.let{
                    selectedOptionView(it, 3)
                }
            }

            R.id.tvOptionFour -> {
                tvOptionFour?.let{
                    selectedOptionView(it, 4)
                }
            }

            R.id.btnSubmit ->{
                if(mSelectedOptionPosition==0){
                    mCurr++;
                    when{
                        mCurr <= mQuestionList!!.size ->{
                            setQuestion()
                        }
                        else ->{
//                            Toast.makeText(this,"You made it to the end", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.username, mUsername)
                            intent.putExtra(Constants.correct_answers, mCorr)
                            intent.putExtra(Constants.total_question, mQuestionList?.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurr  - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.option_wrong_border_bg)
                    }else{
                        mCorr++;
                    }
                    answerView(question.correctAnswer, R.drawable.option_correct_border_bg)

                    if(mCurr == mQuestionList!!.size){
                        btnSubmit?.text = "FINISH"
                    }else{
                        btnSubmit?.text = "NEXT"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1-> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2-> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3-> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4-> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }
    }
}