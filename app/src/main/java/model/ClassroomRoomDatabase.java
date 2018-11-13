package model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import objects.Classroom;



@Database(entities = {Classroom.class}, version = 1)
public abstract class ClassroomRoomDatabase extends RoomDatabase {
    public abstract ClassroomDao classroomDao();

    private static ClassroomRoomDatabase INSTANCE;

    static ClassroomRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ClassroomRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ClassroomRoomDatabase.class, "class_room_table")
                            .fallbackToDestructiveMigration()
                            .build();
                }

            }

        }
        return INSTANCE;
    }
}
