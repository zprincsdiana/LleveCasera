package com.anys.lleve_casera_dv.Pojos;

public class Productos {

    private int id, image ;
    private String nombreProd,precioProd,nombreMerc,nombreDistr;


    public Productos(int id,String nombreProd,String precioProd,String nombreMerc,String nombreDistr,int image){
        this.id = id;
        this.nombreProd = nombreProd;
        this.precioProd = precioProd;
        this.nombreMerc = nombreMerc;
        this.nombreDistr = nombreDistr;
        this.image = image;
    }

    public Productos(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(String precioProd) {
        this.precioProd = precioProd;
    }

    public String getNombreMerc() {
        return nombreMerc;
    }

    public void setNombreMerc(String nombreMerc) {
        this.nombreMerc = nombreMerc;
    }

    public String getNombreDistr() {
        return nombreDistr;
    }

    public void setNombreDistr(String nombreDistr) {
        this.nombreDistr = nombreDistr;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



}
