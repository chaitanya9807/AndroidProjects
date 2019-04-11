package com.chait.quizapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_final.*

class FinalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        var recieve = intent
        var cscore: Int = recieve.getIntExtra("Score", 0)
        var lang=recieve.getIntExtra("Lang",0)
        currentscore.text = cscore.toString()
        //var highScore:Int=0


        var readPreferences = getSharedPreferences("Score", Context.MODE_PRIVATE)
        var chighestScore = readPreferences.getInt("highScore", 0)
        var cpphighestScore = readPreferences.getInt("highScore", 0)
        var javahighestScore = readPreferences.getInt("highScore", 0)
        var pyhighestScore = readPreferences.getInt("highScore", 0)
        var kthighestScore = readPreferences.getInt("highScore", 0)

        when(lang){
            0->{
                langu.text="C"
                if (cscore > chighestScore) {

                    var sharedPrefences: SharedPreferences.Editor = getSharedPreferences("Score", Context.MODE_PRIVATE).edit()
                    sharedPrefences.putInt("highScore", cscore)
                    sharedPrefences.apply()
                    highscore.text=cscore.toString()
                }
                else{
                    highscore.text=chighestScore.toString()
                }
            }
            1->{
                langu.text="C++"
                if (cscore > cpphighestScore) {

                    var sharedPrefences: SharedPreferences.Editor = getSharedPreferences("Score", Context.MODE_PRIVATE).edit()
                    sharedPrefences.putInt("highScore", cscore)
                    sharedPrefences.apply()
                    highscore.text=cscore.toString()
                }
                else{
                    highscore.text=cpphighestScore.toString()
                }
            }
            2->{
                langu.text="Java"
                if (cscore > javahighestScore) {

                    var sharedPrefences: SharedPreferences.Editor = getSharedPreferences("Score", Context.MODE_PRIVATE).edit()
                    sharedPrefences.putInt("highScore", cscore)
                    sharedPrefences.apply()
                    highscore.text=cscore.toString()
                }
                else{
                    highscore.text=javahighestScore.toString()
                }
            }
            3->{
                langu.text="Python"
                if (cscore > pyhighestScore) {

                    var sharedPrefences: SharedPreferences.Editor = getSharedPreferences("Score", Context.MODE_PRIVATE).edit()
                    sharedPrefences.putInt("highScore", cscore)
                    sharedPrefences.apply()
                    highscore.text=cscore.toString()
                }
                else{
                    highscore.text=pyhighestScore.toString()
                }
            }
            4->{
                langu.text="Kotlin"
                if (cscore > kthighestScore) {

                    var sharedPrefences: SharedPreferences.Editor = getSharedPreferences("Score", Context.MODE_PRIVATE).edit()
                    sharedPrefences.putInt("highScore", cscore)
                    sharedPrefences.apply()
                    highscore.text=cscore.toString()
                }
                else{
                    highscore.text=kthighestScore.toString()
                }
            }
//        var handler=Handler()
//        handler.postDelayed(Runnable { finish() },10000)
        }
    }
}
