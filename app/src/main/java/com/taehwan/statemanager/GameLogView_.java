package com.taehwan.statemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class GameLogView_ extends LinearLayout implements View.OnClickListener {

    private static int test =0;
    public GameLogView_(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.content_main, this,true);
    }

    @Override
    public void onClick(View v) {

    }
}
