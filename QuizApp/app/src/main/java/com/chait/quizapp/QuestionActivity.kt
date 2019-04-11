package com.chait.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {
    lateinit var quesArray:Array<String>
    var handler= Handler()
    lateinit var buttons:Array<Button>
    lateinit var optnArray:Array<String>
    lateinit var ansArray:Array<String>
    var counter=0
    var lang=0
    var score=0
    lateinit var countDownTimer:CountDownTimer
    lateinit var life:Array<ImageView>
    var lifecount=2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        life= arrayOf(life1,life2,life3)
        var recieve=intent
        buttons = arrayOf(optn1, optn2, optn3, optn4)
        var selected=recieve.getIntExtra("option",0)
        when(selected){
            R.id.c->{
                //Assign questions,options and answers to quesArray,optnArray and ansArray resp for each case
                quesArray=resources.getStringArray(R.array.Cquestions)
                optnArray=resources.getStringArray(R.array.Coptions)
                ansArray=resources.getStringArray(R.array.Canswers)
            }
            R.id.cpp->{
                lang=1
                quesArray=resources.getStringArray(R.array.Cplusquestions)
                optnArray=resources.getStringArray(R.array.Cplusoptions)
                ansArray=resources.getStringArray(R.array.Cplusanswers)
            }
            R.id.java->{
                lang=2
                quesArray=resources.getStringArray(R.array.Jquestions)
                optnArray=resources.getStringArray(R.array.Joptions)
                ansArray=resources.getStringArray(R.array.Janswers)
            }
            R.id.py->{
                lang=3
                quesArray=resources.getStringArray(R.array.Pyquestions)
                optnArray=resources.getStringArray(R.array.Pyoptions)
                ansArray=resources.getStringArray(R.array.Pyanswers)
            }
            R.id.kotlin->{
                lang=4
                quesArray=resources.getStringArray(R.array.Kquestions)
                optnArray=resources.getStringArray(R.array.Koptions)
                ansArray=resources.getStringArray(R.array.Kanswers)
            }
        }
        timer()
        q.text=quesArray[counter]
        optn1.text=optnArray[counter]
        optn2.text=optnArray[(4*counter)+1]
        optn3.text=optnArray[(4*counter)+2]
        optn4.text=optnArray[(4*counter)+3]
    }
    fun questionLoad(v2:View){
        checkscore(v2)
        quesload()
    }
    @SuppressLint("ResourceAsColor")
    fun markCorrectAns(){
        skipbtn.isEnabled=false
        for(i in buttons){
            i.isEnabled=false
        }
        if(lifecount>=0){
        for(i in buttons) {  // [0(button), 1(button), 2, 3]
            if (i.text == ansArray[counter]) {
                i.setBackgroundResource(R.drawable.greenbtn)
            }
        }
        }
    }
    // Timer work
    fun timer(){
        // CountDownTimer class -->
        // abstract class --> when we don't want to create any instance of a class
        countDownTimer = object : CountDownTimer(21000, 1000){

            override fun onFinish() {
                timertxtview.text="Time's Up!"
                markCorrectAns()
                if(lifecount>=0){
                life[lifecount].visibility=View.INVISIBLE
                lifecount--

                }
                quesload()

            }
            override fun onTick(p0: Long) {
                timertxtview.text = "Time Left: ${p0/1000}"
            }
        }
        countDownTimer.start()
    }
    @SuppressLint("ResourceAsColor")
    fun quesload(){
        skipbtn.isEnabled=false
        countDownTimer.cancel()
        counter++
        var runData= Runnable {

            if (counter < quesArray.size && lifecount >= 0) {
                for(i in buttons){
                    i.isEnabled=true
                }
                q.text = quesArray[counter]
                    optn1.text = optnArray[(4 * counter)]
                    optn2.text = optnArray[(4 * counter) + 1]
                    optn3.text = optnArray[(4 * counter) + 2]
                    optn4.text = optnArray[(4 * counter) + 3]
                    timer()
            }
            else {
                    var intent2 = Intent(this, FinalActivity::class.java)
                    intent2.putExtra("Score", score)
                    intent2.putExtra("Lang",lang)
                    startActivity(intent2)
                    finish()
            }
            for(i in buttons) {
                i.setBackgroundResource(R.color.blue)
            }
        }
        handler.postDelayed(runData,1600)
        skipbtn.isEnabled=true
    }
    fun skip(v3:View){
        skipbtn.isEnabled=false
        if(lifecount>=0){
            life[lifecount].visibility=View.INVISIBLE
            lifecount--
            markCorrectAns()
            quesload()
        }
        else {
            var intent2 = Intent(this, FinalActivity::class.java)
            intent2.putExtra("Score", score)
            intent2.putExtra("Lang",lang)
            startActivity(intent2)
            finish()
        }
    }
//    fun next(v1:View){
//        countDownTimer.cancel()
//        counter++
//        if (counter < quesArray.size && lifecount >= 0) {
//            for(i in buttons){
//                i.isEnabled=true
//            }
//            q.text = quesArray[counter]
//            optn1.text = optnArray[(4 * counter)]
//            optn2.text = optnArray[(4 * counter) + 1]
//            optn3.text = optnArray[(4 * counter) + 2]
//            optn4.text = optnArray[(4 * counter) + 3]
//            timer()
//        } else {
//            var intent2 = Intent(this, FinalActivity::class.java)
//            intent2.putExtra("Score", score)
//            startActivity(intent2)
//            finish()
//        }
//        for(i in buttons) {
//            i.setBackgroundResource(R.color.blue)
//        }
//    }
    @SuppressLint("ResourceAsColor")
    fun checkscore(v2: View){
        skipbtn.isEnabled=false
        for(i in buttons){
            i.isEnabled=false
        }
        var button=findViewById<Button>(v2.id)
        if(button.text==ansArray[counter])
        {
            button.setBackgroundResource(R.drawable.greenbtn)
            score++
        }
        else
        {
            markCorrectAns()
            button.setBackgroundResource(R.drawable.redbtn)
            //to hide life images on every incorrect ans
            life[lifecount].visibility=View.INVISIBLE
            //life[lifecount].visibility = View.INVISIBLE
            lifecount--
        }
    }
}
