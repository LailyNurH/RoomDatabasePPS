package com.thenight.roomdatabase.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thenight.roomdatabase.R;
import com.thenight.roomdatabase.database.dao.MahasiswaDao;
import com.thenight.roomdatabase.database.db.MyApp;
import com.thenight.roomdatabase.database.entity.Mahasiswa;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNama, etNim;
    public final static String TAG_DATA_INTENT = "data_mahasiswa";
    private Mahasiswa mahasiswa;
    private MahasiswaDao dao;
    private Button btnTambah;

    @SuppressLint("setTextll8n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = MyApp.getInstance().getDatabase().userDao();

        if (getIntent() != null) {
            int id = getIntent().getIntExtra(TAG_DATA_INTENT, 0);
            mahasiswa = dao.findById(id);

        }

        btnTambah = findViewById(R.id.btInsert);
        etNama = findViewById(R.id.etNama);
        etNim = findViewById(R.id.etNim);


        if (mahasiswa != null) {
            etNama.setText(mahasiswa.getNama());
            etNim.setText(mahasiswa.getNim());


            btnTambah.setText("Ubah Data");
        }
        btnTambah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        addOrUpdate();
        if (mahasiswa.getId() == 0) {
            dao.insertData(mahasiswa);
        } else {
            dao.update(mahasiswa);
        }
        Toast.makeText(this, btnTambah.getText().toString(), Toast.LENGTH_SHORT).show();
        finish();
    }

    private void addOrUpdate() {
        if (mahasiswa == null) {
            mahasiswa = new Mahasiswa();
        }
        mahasiswa.setNama(etNama.getText().toString());
        mahasiswa.setNim(etNim.getText().toString());

    }


}