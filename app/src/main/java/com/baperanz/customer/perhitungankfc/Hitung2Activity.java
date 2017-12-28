package com.baperanz.customer.perhitungankfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class Hitung2Activity extends AppCompatActivity {
    EditText editLam2, editMi2, editS;
    Button btnHitung2, backBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung2);
        getSupportActionBar().setTitle("Hitung Metode M/M/S/I/I");

        editLam2 = (EditText) findViewById(R.id.editLamda2);
        editMi2 = (EditText) findViewById(R.id.editMiu2);
        editS = (EditText) findViewById(R.id.editS);
        btnHitung2 = (Button) findViewById(R.id.btnHitung2);
    }

    public void clickHitung (View arg0){

        double Lamda2 = Double.parseDouble( editLam2.getText().toString());
        double Miu2 = Double.parseDouble(editMi2.getText().toString());
        double Ser = Double.parseDouble(editS.getText().toString());


        Intent Intentke2 = new Intent(this, Hasil2Activity.class);

        Intentke2.putExtra("Lamda2", Lamda2);
        Intentke2.putExtra("Miu2", Miu2);
        Intentke2.putExtra("Ser", Ser);

        startActivity(Intentke2);




    }

}
