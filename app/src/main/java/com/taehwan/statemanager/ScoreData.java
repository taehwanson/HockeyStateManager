package com.taehwan.statemanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ScoreData {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "home_away")
    public String linkPlace; // home / away

    @ColumnInfo(name = "game_id")
    public String gameId; // time*team1*team2

    @ColumnInfo(name = "time")
    public long time; //

    @ColumnInfo(name = "player_number")
    public Integer backNumber; // 1~99

    @ColumnInfo(name = "player_name")
    public String backName;

    @ColumnInfo(name = "score_type")
    public Integer scoreType; // Goal: 0 / A1 : 1 /A2 :2
}