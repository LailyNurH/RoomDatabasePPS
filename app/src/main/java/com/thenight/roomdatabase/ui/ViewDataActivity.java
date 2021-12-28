package com.thenight.roomdatabase.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.thenight.roomdatabase.R;
import com.thenight.roomdatabase.adapter.RecyclerViewAdapter;
import com.thenight.roomdatabase.common.DataListListener;
import com.thenight.roomdatabase.database.db.MyApp;
import com.thenight.roomdatabase.database.entity.Mahasiswa;

import java.util.List;

public class ViewDataActivity extends AppCompatActivity {
    private RecyclerView rvListMahasiswa;
    private RecyclerViewAdapter adapter;
    FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        rvListMahasiswa = findViewById(R.id.rv_list_mahasiswa);
        fabAdd = findViewById(R.id.fab_tambah_data);

        adapter = new RecyclerViewAdapter();
        rvListMahasiswa.setAdapter(adapter);

        adapter.setRemoveListener(new DataListListener() {
            @Override
            public void onRemoveClick(Mahasiswa mahasiswa) {
                adapter.removeData(mahasiswa);
            }
        });

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewDataActivity.this, MainActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Mahasiswa> datas = MyApp.getInstance().getDatabase().userDao().getAll();
        adapter.setData(datas);
    }

}