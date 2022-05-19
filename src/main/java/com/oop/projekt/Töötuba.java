package com.oop.projekt;


import java.util.ArrayList;
import java.util.List;

public class Töötuba extends VihkameTreeview{

    //lisab osaleja
    //väljastab osaleja(d) ekraanile
    private String töötoaNimi;
    private List<Osaleja> töötoasOsalejad;

    public Töötuba(String töötoaNimi) {
        this.töötoaNimi = töötoaNimi;
        this.töötoasOsalejad =  new ArrayList<>();
    }


    public void lisaOsaleja(Osaleja osaleja) {
        töötoasOsalejad.add(osaleja);
    }
    public  List<Osaleja> kõikTöötoasOsalejad() {
        return töötoasOsalejad;
    }

    public void setName(String töötoaNimi) {
        this.töötoaNimi = töötoaNimi;
    }

    public void setTöötoasOsalejad(List<Osaleja> töötoasOsalejad) {
        this.töötoasOsalejad = töötoasOsalejad;
    }

    @Override
    public String toString() {
        return "Töötuba: "+töötoaNimi;
    }

    // public void kuvaEkraanile() { System.out.println(töötoasOsalejad); }
}
