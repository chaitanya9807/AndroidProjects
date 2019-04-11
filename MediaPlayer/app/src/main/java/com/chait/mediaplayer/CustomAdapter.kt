package com.chait.mediaplayer

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(mainActivity: MainActivity, songs: Array<Int>, songname: Array<String>) :BaseAdapter() {
    var mainActivity:MainActivity=mainActivity
    var songA=songs
    var songs=songname
    @SuppressLint("SetTextI18n", "ViewHolder")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var layoutInflater: LayoutInflater =mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var mediaPlayer = MediaPlayer.create(mainActivity,songA[position])

        var view=layoutInflater.inflate(R.layout.activity_custom , parent, false)

//      var imgview=view.findViewById<ImageView>(R.id.songimage)
        var texts=view.findViewById<TextView>(R.id.songtxt)
        var time=view.findViewById<TextView>(R.id.timetxt)
        time.text=((mediaPlayer.duration)/1000).toBigDecimal().toString()
        texts.text= songs[position]
        return view
    }

    override fun getItem(position: Int): Any {
    return 0
    }

    override fun getItemId(position: Int): Long {
     return 0
    }

    override fun getCount(): Int {
        return songA.size
    }
}