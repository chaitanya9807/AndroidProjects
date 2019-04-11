package com.chait.videoview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pathOfVideo="android.resource://$packageName/${R.raw.sample2}"

        videov.setVideoPath(pathOfVideo)
        var mediaController=MediaController(this)
        videov.setMediaController(mediaController)

        videov.start()
    }
}
