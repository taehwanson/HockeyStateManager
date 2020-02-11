package com.taehwan.statemanager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.MainThread;

public class GameLogView_ extends LinearLayout implements View.OnClickListener {

    private static int test =0;
    public GameLogView_(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.content_main, this,true);
        Intent intent = new Intent(context, ScoreActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }

    private void insertDB() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }).start();

    }


}
