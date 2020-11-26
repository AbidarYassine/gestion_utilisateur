package com.fstg.gestionutilisateur.entities;

import com.fstg.gestionutilisateur.shared.dto.UserDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "addresses")
public class AdresseEntity implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 30)
    private String city;
    @Column(nullable = false, length = 15)
    private String country;
    @Column(nullable = false, length = 50)
    private String adresseId;
    @Column(nullable = false, length = 30)
    private String street;
    @Column(nullable = false, length = 7)
    private String postal;
    @Column(nullable = false, length = 30)
    private String type;
    // la class qui contient foriengKey c'est la classe propritaire
    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(String adresseId) {
        this.adresseId = adresseId;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
