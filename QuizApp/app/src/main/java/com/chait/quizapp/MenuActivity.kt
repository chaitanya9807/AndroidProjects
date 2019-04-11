package com.chait.quizapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }
    fun langselected(v1: View){
        var intent=Intent(this,QuestionActivity::class.java)
        intent.putExtra("option",v1.id)
        startActivity(intent)
    }
}
