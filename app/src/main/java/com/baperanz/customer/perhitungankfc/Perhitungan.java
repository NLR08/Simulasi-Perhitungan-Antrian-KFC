package com.baperanz.customer.perhitungankfc;

/**
 * Created by USER on 27/12/2017.
 */

public class Perhitungan {
    String pe;
    String eles;
    String elqi;
    String weqi;
    String wees;
    String penol;

    public Perhitungan(String pe, String eles, String elqi, String weqi, String wees, String penol) {
        this.pe = pe;
        this.eles = eles;
        this.elqi = elqi;
        this.weqi = weqi;
        this.wees = wees;
        this.penol = penol;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getEles() {
        return eles;
    }

    public void setEles(String eles) {
        this.eles = eles;
    }

    public String getElqi() {
        return elqi;
    }

    public void setElqi(String elqi) {
        this.elqi = elqi;
    }

    public String getWeqi() {
        return weqi;
    }

    public void setWeqi(String weqi) {
        this.weqi = weqi;
    }

    public String getWees() {
        return wees;
    }

    public void setWees(String wees) {
        this.wees = wees;
    }

    public String getPenol() {
        return penol;
    }

    public void setPenol(String penol) {
        this.penol = penol;
    }
}
