package com.taehwan.statemanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout

class GameLogView__(context: Context) : LinearLayout(context), View.OnClickListener {
    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.content_main, this, true)
    }

    override fun onClick(v: View) {

    }

    private fun insertDB() {
        object : Thread() {
            override fun run() {

            }
        }.start()
    }

    companion object {

        private val test = 0
    }
}
