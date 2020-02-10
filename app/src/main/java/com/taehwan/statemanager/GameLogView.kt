package com.taehwan.statemanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Switch
import kotlinx.android.synthetic.main.goalee_panel.view.*
import androidx.room.Room
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log


class GameLogView(context: Context) : LinearLayout(context), View.OnClickListener {
    companion object {

    }
    private var mContext : Context?=null
    private var mGoalee1P = 0
    private var mGoalee2P = 0
    private var mGoalee3P = 0

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.content_main, this, true)
        mContext = context
        mP1Up.setOnClickListener(this)
        mP1Down.setOnClickListener(this)
        mP2Up.setOnClickListener(this)
        mP2Down.setOnClickListener(this)
        mP3Up.setOnClickListener(this)
        mP3Down.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v){
            mP1Up -> mP1Goalee.text = (++mGoalee1P).toString();
            mP1Down -> mP1Goalee.text = ( if( mGoalee1P > 0 ) --mGoalee1P else mGoalee1P ).toString()
            mP2Up -> mP2Goalee.text = (++mGoalee2P).toString()
            mP2Down -> mP2Goalee.text = (if( mGoalee2P > 0 ) --mGoalee2P else mGoalee2P ).toString()
            mP3Up -> mP3Goalee.text = (++mGoalee3P).toString()
            mP3Down -> mP3Goalee.text = (if( mGoalee3P >0 ) --mGoalee3P else mGoalee3P ).toString()
        }
        mTotal.text = (mGoalee1P + mGoalee2P + mGoalee3P).toString()

        selectAll()
    }

//    private fun insertDB() {
//        object : Thread() {
//            override fun run() {
//                val db = Room.databaseBuilder(
//                    mContext!!.applicationContext,
//                    AppDataBase::class.java!!, "database-name"
//                ).build()
//
//                var scoreData = ScoreData()
//
//                scoreData.backName = "taehwan"
//                scoreData.backNumber = 40
//                scoreData.gameId = "test_test"
//                scoreData.linkPlace = "home"
//                scoreData.scoreType = 1
//                scoreData.time = System.currentTimeMillis()
//
//                db.scoreDataDao().insertAll(scoreData)
//            }
//        }.start()
//    }

    private fun selectAll() {
        object : Thread() {
            override fun run() {
                val db = Room.databaseBuilder(
                    mContext!!.applicationContext,
                    AppDataBase::class.java!!, "database-name"
                ).build()

                var scoreDataList = db.scoreDataDao().all
                Log.d("TAG","test")
            }
        }.start()
    }
}
