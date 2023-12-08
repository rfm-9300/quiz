package com.rfm.appquiz.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rfm.appquiz.Utils.Constants

class QuestionsViewModel : ViewModel() {

    private val _currentPosition = MutableLiveData<Int>()
    private var correctAnswer: Int? = null
    private var selectedAnswer: Int? = null
    private val questionList: MutableList<Question> = Constants.getQuestions()

    fun getCurrentPosition() = _currentPosition

    fun getProgressBarMax() = questionList.size

    fun getQuestion(): Question {
        if (_currentPosition.value == null) {
            _currentPosition.value = 1
        }
        val currentQuestion = _currentPosition.value
        val question = questionList[currentQuestion!! - 1]
        correctAnswer = question.correctAnswer
        return question
    }

    fun setSelectedAnswer(answer: Int) {
        selectedAnswer = answer
    }

    fun checkAnswer(): Boolean {
        return correctAnswer == selectedAnswer
    }

    fun moveToNextQuestion() {
        _currentPosition.value = _currentPosition.value?.plus(1)
    }
}