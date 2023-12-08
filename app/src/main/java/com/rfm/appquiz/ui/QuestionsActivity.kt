package com.rfm.appquiz.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rfm.appquiz.Utils.Constants
import com.rfm.appquiz.databinding.ActivityQuestionsBinding
import com.rfm.appquiz.model.Question
import com.rfm.appquiz.model.QuestionsViewModel

class QuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionsBinding
    private lateinit var viewModel: QuestionsViewModel

    private lateinit var progressBar : ProgressBar
    private lateinit var textViewProgress : TextView
    private lateinit var textViewQuestion : TextView
    private lateinit var flagImage : ImageView
    private var currentPosition = 1
    private lateinit var questionList :MutableList<Question>


    private lateinit var textViewOptionOne : TextView
    private lateinit var textViewOptionTwo : TextView
    private lateinit var textViewOptionThree : TextView
    private lateinit var textViewOptionFour : TextView

    private lateinit var checkButton: Button

    var correctAnswer: Int? = null
    var selectedAnswer: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)




        progressBar = binding.progressBar
        textViewProgress = binding.progressTextView
        textViewQuestion = binding.questionTextView
        flagImage = binding.imageFlag

        textViewOptionOne = binding.answerTextView1
        textViewOptionTwo = binding.answerTextView2
        textViewOptionThree = binding.answerTextView3
        textViewOptionFour = binding.answerTextView4

        checkButton = binding.checkButton

        questionList = Constants.getQuestions()
        Log.d("Questions Size", "${questionList.size}")
        setQuestion()

        textViewOptionOne.setOnClickListener {
            viewModel.setSelectedAnswer(1)
            Log.d("cu", "$selectedAnswer meu pau")
        }
        textViewOptionTwo.setOnClickListener {
            viewModel.setSelectedAnswer(2)
            Log.d("cu", "$selectedAnswer meu pau")
        }
        textViewOptionThree.setOnClickListener {
            viewModel.setSelectedAnswer(3)
            Log.d("cu", "$selectedAnswer meu pau")
        }
        textViewOptionFour.setOnClickListener {
            viewModel.setSelectedAnswer(4)
            Log.d("cu", "$selectedAnswer meu pau")
        }

        checkButton.setOnClickListener {
            if (viewModel.checkAnswer()) {
                viewModel.moveToNextQuestion()
                setQuestion()
            } else {
                Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show()

            }
        }

        // Observe changes in ViewModel properties and update UI accordingly
        viewModel.getCurrentPosition().observe(this) { currentPosition ->
            progressBar.progress = currentPosition
            textViewProgress.text = "$currentPosition" + "/" + viewModel.getProgressBarMax()

        }


    }
    private fun selectedOption(i: Int) {
        selectedAnswer = i

    }

    private fun setQuestion(){
        val question = viewModel.getQuestion()
        correctAnswer = question.correctAnswer


        textViewQuestion.text = question.question
        flagImage.setImageResource(question.image)
        textViewOptionOne.text = question.optionOne
        textViewOptionTwo.text = question.optionTwo
        textViewOptionThree.text = question.optionThree
        textViewOptionFour.text = question.optionFour
    }
}