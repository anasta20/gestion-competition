package com.gestioncompetition.service.impl;

import com.gestioncompetition.dto.JwtAuthenticationResponse;
import com.gestioncompetition.dto.RefreshTokenRequest;
import com.gestioncompetition.dto.SignUpRequest;
import com.gestioncompetition.dto.SigninRequest;
import com.gestioncompetition.entity.Candidat;
import com.gestioncompetition.entity.Role;
import com.gestioncompetition.repository.CandidatRepository;
import com.gestioncompetition.service.AuthenticationService;
import com.gestioncompetition.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final CandidatRepository candidatRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;


    public Candidat signup(SignUpRequest signUpRequest){
        if( !isCandidatExist(signUpRequest.getEmail())) { //if the user is not exist create a new user

            Candidat candidat = new Candidat();

            candidat.setEmail(signUpRequest.getEmail());
            candidat.setPrenom(signUpRequest.getPrenom());
            candidat.setNom(signUpRequest.getNom());
            candidat.setSexe(signUpRequest.getSexe());
            candidat.setRole(signUpRequest.getRole());
            candidat.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

            return candidatRepository.save(candidat);

        }
        throw new IllegalArgumentException("Le candidat existe déjà. Impossible de le rajouter");

    }

    public boolean isCandidatExist(String email){
        Candidat candidat = candidatRepository.findByEmail(email).orElse(null);
        if(candidat == null) return false;
        return true;
    }// candidat return all the information of an candidat if Exist

    public JwtAuthenticationResponse signin(SigninRequest signinRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
        var candidat = candidatRepository.findByEmail(signinRequest.getEmail()).orElseThrow(()-> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(candidat);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), candidat);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String candidatEmail = jwtService.extractCandidatName(refreshTokenRequest.getToken());
        Candidat candidat = candidatRepository.findByEmail(candidatEmail).orElseThrow();
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(), candidat)){
            var jwt =jwtService.generateToken(candidat);

            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }
}
