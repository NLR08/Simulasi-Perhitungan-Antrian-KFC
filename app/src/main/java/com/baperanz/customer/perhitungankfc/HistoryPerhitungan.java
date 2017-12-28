package com.baperanz.customer.perhitungankfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HistoryPerhitungan extends AppCompatActivity {

    private ArrayList<Perhitungan> perhitunganModel = new ArrayList<>();
    private RecyclerView recHistory;
    private PerhitunganAdapter perhitunganAdapter;
    private TextView notview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_perhitungan);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("perhitungan");
        notview = (TextView) findViewById(R.id.txtTidakada);
        perhitunganAdapter = new PerhitunganAdapter(getBaseContext(),perhitunganModel);
        recHistory = (RecyclerView) findViewById(R.id.recHistory);
        recHistory.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recHistory.setAdapter(perhitunganAdapter);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                perhitunganModel.clear();
//                DataSnapshot currentData = dataSnapshot;
                for(DataSnapshot currentData : dataSnapshot.getChildren() ){
                    String pe = String.valueOf(currentData.child("pe").getValue());
                    String elqi = String.valueOf(currentData.child("elqi").getValue());
                    String eles = String.valueOf(currentData.child("eles").getValue());
                    String weqi = String.valueOf(currentData.child("weqi").getValue());
                    String wees = String.valueOf(currentData.child("wees").getValue());
                    String penol = String.valueOf(currentData.child("penol").getValue());
                    Perhitungan dataperhitungan = new Perhitungan(pe,eles,elqi,weqi,wees,penol);
                    perhitunganModel.add(dataperhitungan);
                }
                recHistory.setAdapter(perhitunganAdapter);
                perhitunganAdapter.notifyDataSetChanged();
                notview.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
