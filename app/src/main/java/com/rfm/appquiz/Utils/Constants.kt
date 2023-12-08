package com.rfm.appquiz.Utils

import com.rfm.appquiz.R
import com.rfm.appquiz.model.Question

object Constants {

    fun getQuestions(): MutableList<Question> {
        val questionsList = mutableListOf<Question>()

        val quest1 = Question(
            1,
            "¿cual pais bandeira",
            R.drawable.al,
            "Albania",
            "Alemania",
            "Andorra",
            "Angola",
            1
        )

        val quest2 = Question(
            2,
            "¿cual pais bandeira",
            R.drawable.ar,
            "Argentina",
            "Armenia",
            "Australia",
            "Austria",
            1
        )

        val quest3 = Question(
            3,
            "¿cual pais bandeira",
            R.drawable.at,
            "Austria",
            "Armenia",
            "Australia",
            "Azerbaiyán",
            1
        )

        val quest4 = Question(
            4,
            "¿cual pais bandeira",
            R.drawable.au,
            "Austria",
            "Armenia",
            "Australia",
            "Azerbaiyán",
            3
        )

        val quest5 = Question(
            5,
            "¿cual pais bandeira",
            R.drawable.az,
            "Austria",
            "Armenia",
            "Australia",
            "Azerbaiyán",
            4
        )

        val quest6 = Question(
            6,
            "¿cual pais bandeira",
            R.drawable.ba,
            "Austria",
            "Armenia",
            "Australia",
            "Bosnia y Herzegovina",
            4
        )

        val quest7 = Question(
            7,
            "¿cual pais bandeira",
            R.drawable.be,
            "Austria",
            "Armenia",
            "Australia",
            "Bélgica",
            4
        )

        val quest8 = Question(
            8,
            "¿cual pais bandeira",
            R.drawable.bg,
            "Austria",
            "Armenia",
            "Australia",
            "Bulgaria",
            4
        )

        val quest9 = Question(
            9,
            "¿cual pais bandeira",
            R.drawable.br,
            "Austria",
            "Armenia",
            "Australia",
            "Brasil",
            4
        )

        val quest10 = Question(
            10,
            "¿cual pais bandeira",
            R.drawable.ca,
            "Austria",
            "Armenia",
            "Australia",
            "Canadá",
            4
        )

            questionsList.add(quest1)
            questionsList.add(quest2)
            questionsList.add(quest3)
            questionsList.add(quest4)
            questionsList.add(quest5)
            questionsList.add(quest6)
            questionsList.add(quest7)
            questionsList.add(quest8)
            questionsList.add(quest9)
            questionsList.add(quest10)

        return questionsList




    }
}