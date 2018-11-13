package model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import objects.Classroom;

@Dao
public interface ClassroomDao {
    @Insert
    void insert(Classroom classroom);

    @Insert
    void insertAll(List<Classroom> list_classroom);

    @Query("DELETE FROM class_room_table")
    void deleteAll();

    @Query("SELECT * from class_room_table ORDER BY idClassRoom ASC")
    LiveData<List<Classroom>> getAllClassrooms();
}
