package com.chait.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var songs= arrayOf(R.raw.cheap_thrills,R.raw.drake,R.raw.fast_and_furious,R.raw.ilikeit,R.raw.magenta_riddim,R.raw.pyscho)
    var songname=arrayOf("Cheap Thrills","Drake","Fast and Furious","I Like It","Magenta Riddim","Psycho" )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mediaPlayer=MediaPlayer.create(this,R.raw.pyscho)
//        var mediaPlayer = MediaPlayer.create(this, R.raw.drake)
         list.adapter=CustomAdapter(this,songs,songname)

//        play.setOnClickListener {
//            if(mediaPlayer==null){
//                mediaPlayer=MediaPlayer.create(this,R.raw.drake)
//            }
//            mediaPlayer.start()//will start playing the song
//
//        }
//        pause.setOnClickListener {
//            mediaPlayer.pause()//will pause the song
//        }
//        stop.setOnClickListener {
//            mediaPlayer.stop()//will stop the song
//            mediaPlayer.release()
//            mediaPlayer= null
//        }

        list.setOnItemClickListener { parent, view, position, id ->
//            list.adapter=CustomAdapter2(this,songs,songname)
            mediaPlayer.stop()
            mediaPlayer.release()
            mediaPlayer = MediaPlayer.create(this, songs[position])
            songtxts.text=songname[position]
            songimage.setImageResource(android.R.drawable.ic_media_play)
            mediaPlayer.start()
        }

        linearlay.setOnClickListener{
            if(mediaPlayer.isPlaying){
                mediaPlayer.pause()
                songimage.setImageResource(android.R.drawable.ic_media_pause)
            }
            else {
                mediaPlayer.start()
                songimage.setImageResource(android.R.drawable.ic_media_play)
            }

        }
    }
    }

