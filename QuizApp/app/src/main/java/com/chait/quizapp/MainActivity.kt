package com.chait.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Handler is a predefined class to handle delayed functionalities
        var handler=Handler()

        //Runnable is a predefined interface
        //used for multi threading work
        //when an app executes, two threads are working
        //1st UIThread --> the thread that manages the UI
        //2nd MainThread --> which manages the entire package

        //ONE WAY

        /*handler.postDelayed(Runnable{
            //1st way
            *//*var intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)*//*
            //2nd way
            startActivity(Intent(this,MenuActivity::class.java))
        },30000)*/

        //SECOND WAY

        var runData= Runnable {
            startActivity(Intent(this,MenuActivity::class.java))
            finish()
        }
        handler.postDelayed(runData,3000)
    }
}
