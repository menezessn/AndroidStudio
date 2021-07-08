package com.example.mapslistview;

public class Lugar {
    private String nome, endereco;
    private double longitude, latitude;

    public Lugar(String nome, String endereco, double longitude, double latitude) {
        this.nome = nome;
        this.endereco = endereco;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
