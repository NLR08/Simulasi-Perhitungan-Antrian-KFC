package com.baperanz.customer.perhitungankfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class HasilActivity extends AppCompatActivity {
    TextView txtElqi, txtEles, txtWeqi, txtWees, txtPe, txtPenol;
    Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        getSupportActionBar().setTitle("Hasil Metode M/G/1/I/I");

        txtPe = (TextView) findViewById(R.id.hasil1);
        txtElqi = (TextView) findViewById(R.id.hasil2);
        txtEles = (TextView) findViewById(R.id.hasil3);
        txtWeqi = (TextView) findViewById(R.id.hasil4);
        txtWees = (TextView) findViewById(R.id.hasil5);
        txtPenol = (TextView) findViewById(R.id.hasil6);
        btnNext = (Button)findViewById(R.id.buttonNext);
        btnBack = (Button)findViewById(R.id.buttonBack);

        Intent myLocal = getIntent();

        //get dari extra


        double lam = myLocal.getDoubleExtra("Lamda", -1);
        double myu = myLocal.getDoubleExtra("Miu", -1);
        double std = myLocal.getDoubleExtra("Std", -1);


        double pe = (lam / myu);
        double elqi = (((lam*lam)*(std*std)) + (pe*pe)) / (2 * (1 - pe));
        double eles = elqi + pe;
        double weqi = elqi/lam;
        double wees = weqi + (1/myu);
        double penol = 1 - pe;

        txtPe.setText("Probabilitas fasilitas pelayanan sibuk : " + String.format("%.2f", pe) + "");
        txtElqi.setText("Jumlah Individu Dalam Antrian : " + elqi + "orang");
        txtEles.setText("Jumlah Individu Dalam Sistem : " + eles);
        txtWeqi.setText("Waktu Rata2 dalam Antrian : " + weqi);
        txtWees.setText("Waktu Rata2 dalam Sistem : " + wees);
        txtPenol.setText("Probabilitas Server Idle : " + penol);

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = mDatabase.getReference("perhitungan");
        String key = ref.push().getKey();
        HashMap<String,String> dataSave = new HashMap<>();
        dataSave.put("pe", String.valueOf(pe));
        dataSave.put("elqi", String.valueOf(elqi));
        dataSave.put("eles", String.valueOf(eles));
        dataSave.put("weqi", String.valueOf(weqi));
        dataSave.put("wees", String.valueOf(wees));
        dataSave.put("penol", String.valueOf(penol));
        ref.child(key).setValue(dataSave);
//        ref.child(key).child("op").setValue("kk");
//        ref.child(key).child("ol").setValue("kkk");

//        Integer totalsigma = 0;
//        for(Integer i=0;i<3;i++){
//            totalsigma += (36*2);
//        }


    }


        public void Backclik(View view) {
            Intent ii =new Intent(getApplicationContext(), HitungActivity.class);
            startActivity(ii);
        }


         public void Nextclik(View view) {
        Intent i =new Intent(getApplicationContext(), Hitung2Activity.class);
        startActivity(i);
    }

}