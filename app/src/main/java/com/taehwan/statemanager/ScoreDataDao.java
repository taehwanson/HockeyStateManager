package com.taehwan.statemanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ScoreDataDao {
    @Query("SELECT * FROM scoreData")
    List<ScoreData> getAll();

    @Query("SELECT * FROM scoreData WHERE home_away IN ( :linkPlace )")
    List<ScoreData> loadAllByLinkPlace(String linkPlace);

//    @Query("SELECT * FROM scoreData WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    ScoreData findByName(String first, String last);

    @Insert
    void insertAll(ScoreData... scoreDataArray);

    @Delete
    void delete(ScoreData scoreData);
}