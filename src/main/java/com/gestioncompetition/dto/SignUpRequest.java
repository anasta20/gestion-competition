package com.gestioncompetition.dto;

import com.gestioncompetition.entity.Role;
import lombok.Data;

@Data
public class SignUpRequest {

    private String nom;
    private String prenom;
    private String email;
    private String sexe;
    private String password;
    private Role role;

}
