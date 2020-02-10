package com.taehwan.statemanager;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ScoreData.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract ScoreDataDao scoreDataDao();
}