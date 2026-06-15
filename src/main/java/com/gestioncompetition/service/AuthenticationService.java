package com.gestioncompetition.service;

import com.gestioncompetition.dto.JwtAuthenticationResponse;
import com.gestioncompetition.dto.RefreshTokenRequest;
import com.gestioncompetition.dto.SignUpRequest;
import com.gestioncompetition.dto.SigninRequest;
import com.gestioncompetition.entity.Candidat;

public interface AuthenticationService {

    Candidat signup(SignUpRequest signUpRequest);// Retourne tout les information de candidat inclus les info de compte
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
