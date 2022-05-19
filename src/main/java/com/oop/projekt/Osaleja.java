package com.oop.projekt;

public class Osaleja extends VihkameTreeview{
    //osaleb töötoas
    private String nimi;
    //private List<Töötuba> tööToad;

    public Osaleja(String nimi) {
        this.nimi = nimi;
        //this.tööToad = new ArrayList<>();
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) { this.nimi = nimi; }

    //public void lisaTöötuppa (Töötuba tuba){tööToad.add(tuba);}

    @Override
    public String toString() {
        return "Osaleja: "+nimi;
    }
    //public void kuvaEkraanile() {System.out.println(tööToad);}
}

