package com.thenight.roomdatabase.database.db;

import android.app.Application;

import androidx.room.Room;

public class MyApp extends Application {
    private static MyApp INSTANCE;
    public static AppDatabase db;
    public static MyApp getInstance(){
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(this,
                AppDatabase.class,"database_mahasiswa")
                .allowMainThreadQueries().build();
        INSTANCE = this;
    }
    public  AppDatabase getDatabase(){
        return db;
    }

}