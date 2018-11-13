package model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

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
                            .addCallback(new Callback() {
                                @Override
                                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                    super.onOpen(db);
                                    new classroomsAsyncTask(INSTANCE).execute();

                                }
                            })
                            .build();
                }

            }

        }
        return INSTANCE;
    }

    private static class classroomsAsyncTask extends AsyncTask< Void, Void, Void> {

        private ClassroomDao mAsyncTaskDao;

        classroomsAsyncTask(ClassroomRoomDatabase dao) {
            mAsyncTaskDao = INSTANCE.classroomDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            Classroom classroom = new Classroom(0,"DAMP",24,5,"Chema");
            List<Classroom> data = new ArrayList<>();
            data.add(classroom);
            mAsyncTaskDao.deleteAll();
            mAsyncTaskDao.insertAll(data);
            return null;

        }
    }

}
