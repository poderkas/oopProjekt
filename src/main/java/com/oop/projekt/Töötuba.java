package com.oop.projekt2;


import java.util.ArrayList;
import java.util.List;

public class Töötuba {

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

    public String getTöötoaNimi() {
        return töötoaNimi;
    }



    @Override
    public String toString() {
        return "Töötuba{" +
                "töötoaNimi='" + töötoaNimi + '\'' +
                ", töötoasOsalejad=" + töötoasOsalejad +
                '}';
    }

    // public void kuvaEkraanile() { System.out.println(töötoasOsalejad); }
}
