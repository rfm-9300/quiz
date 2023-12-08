package com.rfm.appquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.rfm.appquiz.databinding.ActivityMainBinding
import com.rfm.appquiz.ui.QuestionsActivity


private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var startButton : Button
    private lateinit var myText : TextView
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startButton = binding.buttonStart
        editText = binding.name

        startButton.setOnClickListener {
            if(!editText.text.toString().isEmpty()){
                Intent(this, QuestionsActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
        } else {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }


    }


}