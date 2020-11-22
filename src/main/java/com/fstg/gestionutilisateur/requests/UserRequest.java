package com.fstg.gestionutilisateur.requests;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequest {
    @Size(min = 5)
    @NotNull(message = "Ce champ est obligatoire")
    private String fistName;

    @Size(min = 5, max = 20)
    @NotNull(message = "Ce champ est obligatoire")
    private String lastName;

    @Email(message = "Email ne respecte pas la norme ")
    private String email;

    @Size(min = 8, max = 12)
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\n", message = "Le mot de passe ne respecte pas la forme")
    private String password;

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
