package com.fstg.gestionutilisateur.shared.dto;
import com.fstg.gestionutilisateur.shared.dto.UserDto;

public class AddressDto {



    private long id;
    private String city;
    private String country;
    private String street;
    private String postal;
    private String AdresseId;

    public String getAdresseId() {
        return AdresseId;
    }

    public void setAdresseId(String adresseId) {
        AdresseId = adresseId;
    }

    private String type;
    // an adresse a partient a un et un seul Utilisateur
    private UserDto userDto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", postal='" + postal + '\'' +
                ", type='" + type + '\'' +
                ", userDto=" + userDto +
                '}';
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
