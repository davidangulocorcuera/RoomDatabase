package model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import objects.Player;

@Database(entities = {Player.class}, version = 1)
public abstract class PlayerRoomDatabase extends RoomDatabase {

    public abstract PlayerDao playerDao();

    private static PlayerRoomDatabase INSTANCE;

    static PlayerRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PlayerRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PlayerRoomDatabase.class, "players")
                            .fallbackToDestructiveMigration()
                            .build();
                }

            }

        }
        return INSTANCE;
    }
}




