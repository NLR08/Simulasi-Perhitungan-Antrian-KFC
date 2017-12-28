package com.baperanz.customer.perhitungankfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HitungActivity extends AppCompatActivity {
    EditText editLam, editMi, editSt;
    Button btnHasil,btnhistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung);

        getSupportActionBar().setTitle("Hitung Metode M/G/1/I/I");
        btnhistory = (Button) findViewById(R.id.btnHistory);
        editLam = (EditText) findViewById(R.id.editLamda2);
        editMi = (EditText) findViewById(R.id.editMiu2);
        editSt = (EditText) findViewById(R.id.editS);

        btnHasil = (Button) findViewById(R.id.btnHitung);
        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //colect data dari UI

                double Lamda = Double.parseDouble( editLam.getText().toString());
                double Miu = Double.parseDouble(editMi.getText().toString());
                double Std = Double.parseDouble(editSt.getText().toString());

                //membuat intent untuk memanggil window ke 2

                Intent myIntent = new Intent(HitungActivity.this, HasilActivity.class);

                //supply intent dengan putextra
                myIntent.putExtra("Lamda", Lamda);
                myIntent.putExtra("Miu", Miu);
                myIntent.putExtra("Std", Std);

                //start
                startActivity(myIntent);
            }
        });

        btnhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HitungActivity.this,HistoryPerhitungan.class);
                startActivity(i);
            }
        });
    }

}