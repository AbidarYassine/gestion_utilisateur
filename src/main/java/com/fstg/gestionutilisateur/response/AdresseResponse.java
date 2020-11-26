package com.fstg.gestionutilisateur.response;

public class AdresseResponse {

    private String city;
    private String country;
    private String street;
    private String postal;
    private String AdresseId;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getAdresseId() {
        return AdresseId;
    }

    public void setAdresseId(String adresseId) {
        AdresseId = adresseId;
    }
}
