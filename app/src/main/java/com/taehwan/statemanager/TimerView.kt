package com.taehwan.statemanager

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import androidx.room.Room
import kotlinx.android.synthetic.main.goalee_panel.view.*
import kotlinx.android.synthetic.main.penalty_timer.view.*


class TimerView(context: Context, parent: ViewGroup, playerNum: Int, sec: Int) : LinearLayout(context), View.OnClickListener {
    companion object {

    }
    private var mContext : Context?=null
    private var mParent : ViewGroup?=null
    private var mSec =0


    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.penalty_timer, this, true)
        mContext = context
        mParent = parent
        mSec = sec
        mPenaltyNumber.text = playerNum.toString()
        mClose.setOnClickListener(this)
        mPenaltyTimerBody.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v) {
            mClose -> mParent!!.removeView(this)
            mPenaltyTimerBody -> startTimer()
        }

        selectAll()
    }

    private fun startTimer() {
        Thread(Runnable {
            while (true) {
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                --mSec
                var sec = mSec%60
                var min = mSec/60
                Handler(Looper.getMainLooper()).post {
                    if( mSec == 0) {
                        mParent!!.removeView(this)
                    } else {
                        mPenaltyTimerMin.text = min.toString()
                        mPenaltyTimerSec.text = sec.toString()
                    }
                }
                if( mSec == 0) {
                    break
                }
            }
        }).start()

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
