package com.baperanz.customer.perhitungankfc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by USER on 27/12/2017.
 */

public class PerhitunganAdapter extends RecyclerView.Adapter<PerhitunganAdapter.MyViewHolder> {
    private ArrayList<Perhitungan> perhitungan;
    private Context context;
    private LayoutInflater inflater;

    public PerhitunganAdapter(Context context,ArrayList<Perhitungan> mymodel) {
        this.context = context;
        this.perhitungan = mymodel;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public PerhitunganAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.layperhitungan,parent,false));
    }

    @Override
    public void onBindViewHolder(PerhitunganAdapter.MyViewHolder holder, int position) {
        Perhitungan currentData = perhitungan.get(position);
        holder.txtPe.setText("Probabilitas fasilitas pelayanan sibuk : " + currentData.getPe() + "");
        holder.txtElqi.setText("Jumlah Individu Dalam Antrian : " + currentData.getElqi() + "orang");
        holder.txtEles.setText("Jumlah Individu Dalam Sistem : " + currentData.getEles());
        holder.txtWeqi.setText("Waktu Rata2 dalam Antrian : " + currentData.getWeqi());
        holder.txtWees.setText("Waktu Rata2 dalam Sistem : " + currentData.getWees());
        holder.txtPenol.setText("Probabilitas Server Idle : " + currentData.getPenol());
    }

    @Override
    public int getItemCount() {
        return perhitungan.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtElqi, txtEles, txtWeqi, txtWees, txtPe, txtPenol;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtPe = (TextView) itemView.findViewById(R.id.hasil1);
            txtElqi = (TextView) itemView.findViewById(R.id.hasil2);
            txtEles = (TextView) itemView.findViewById(R.id.hasil3);
            txtWeqi = (TextView) itemView.findViewById(R.id.hasil4);
            txtWees = (TextView) itemView.findViewById(R.id.hasil5);
            txtPenol = (TextView) itemView.findViewById(R.id.hasil6);
        }
    }
}
