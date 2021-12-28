package com.thenight.roomdatabase.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mahasiswa {

    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    @ColumnInfo(name = "nama")
    private String nama = "";

    @ColumnInfo(name = "nim")
    private String nim = "";


    public Mahasiswa() {
    }

    public Mahasiswa(int id, String nama, String nim) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() { return nama; }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() { return nim; }

    public void setNim(String nim) {
        this.nim = nim;
    }


}