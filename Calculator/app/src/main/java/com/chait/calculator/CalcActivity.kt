package com.chait.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calc.*
import java.sql.Types.NULL

class CalcActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
    }

    var a: Int = 0
    var c: String = NULL.toString()
    var result: Any = 0
    var b: Int = 0
    @SuppressLint("SetTextI18n")
    fun onbuttonclick(v: View) {
        var button = findViewById<Button>(v.id)

        if (button.text.toString() != '='.toString()) {
            textview1.text = textview1.text.toString() + button.text.toString()
            a = a * 10 + button.text.toString().toInt()
        }
        when {
            button.text.toString() == '='.toString() -> {
                result = when (c) {
                    '+'.toString() -> a + b
                    '-'.toString() -> b - a
                    'x'.toString() -> a * b
                    '/'.toString() -> b / a
                    else -> 0
                }
                b=0
                textview2.setText(result.toString())
                c= NULL.toString()
                a=result.toString().toInt()
            }
        /*if(requested)
        {
            b=b*10+button.text.toString().toInt()
            textview2.text=when(c){
                "+"->(a+b).toString()
                "-"->(a-b).toString()
                "x"->(a*b).toString()
                "/"->(a/b).toString()
                else->""
            }
        */
        }
        /*if(requested)
        {
            b=b*10+button.text.toString().toInt()
            textview2.text=when(c){
                "+"->(a+b).toString()
                "-"->(a-b).toString()
                "x"->(a*b).toString()
                "/"->(a/b).toString()
                else->""
            }
        */
    }
    @SuppressLint("SetTextI18n")
//var flag=1
    fun operationrequest(v1: View) {
        var button1 = findViewById<Button>(v1.id)
        //if(flag==1){
            textview1.text = textview1.text.toString() + button1.text.toString()
            c = button1.text.toString()
            b = a
            a = 0
            //flag++
        //}
        /*else{
            textview1.text=b.toString()+button1.text.toString()
            flag--
        }*/
        /*if(a==0)
            a=textview1.text.toString().toInt()
        else {
            a = textview2.text.toString().toInt()
        }
        var button1=findViewById<Button>(v1.id)
        textview1.text= textview1.text.toString()+button1.text.toString()
        c=button1.text.toString()
        requested=true

    }*/

    }


    fun clear(v2: View) {
        var button2 = findViewById<Button>(v2.id)
        a = 0
        b = 0
        c = NULL.toString()
        textview2.text = ""
        textview1.text = ""
    }
}

