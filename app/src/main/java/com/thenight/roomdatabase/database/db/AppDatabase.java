package com.thenight.roomdatabase.database.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.thenight.roomdatabase.database.dao.MahasiswaDao;
import com.thenight.roomdatabase.database.entity.Mahasiswa;

@Database(entities = {Mahasiswa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MahasiswaDao userDao();
}
