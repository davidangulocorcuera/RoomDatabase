package model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import objects.Classroom;

public class ClassroomRepository {
    private ClassroomDao classroomDao;
    private LiveData<List<Classroom>> mAllClassrooms;

    public ClassroomRepository(Application application) {
        ClassroomRoomDatabase db = ClassroomRoomDatabase.getDatabase(application);
        classroomDao = db.classroomDao();
        mAllClassrooms = classroomDao.getAllClassrooms();
    }

    LiveData<List<Classroom>> getmAllClassrooms() {
        return mAllClassrooms;
    }

    public void insert (Classroom classroom) {
        new insertAsyncTask(classroomDao).execute(classroom);
    }

    private static class insertAsyncTask extends AsyncTask<Classroom, Void, Void> {

        private ClassroomDao mAsyncTaskDao;

        insertAsyncTask(ClassroomDao dao) {
            mAsyncTaskDao = dao;
        }


        @Override
        protected Void doInBackground(Classroom... classrooms) {
            mAsyncTaskDao.insert(classrooms[0]);
            return null;
        }
    }
}
