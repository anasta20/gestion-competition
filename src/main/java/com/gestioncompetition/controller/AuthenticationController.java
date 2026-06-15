package com.gestioncompetition.controller;

import com.gestioncompetition.dto.JwtAuthenticationResponse;
import com.gestioncompetition.dto.RefreshTokenRequest;
import com.gestioncompetition.dto.SignUpRequest;
import com.gestioncompetition.dto.SigninRequest;
import com.gestioncompetition.entity.Candidat;
import com.gestioncompetition.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/singup")
    public ResponseEntity<Candidat> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    } //signup : fonction dans service
    // jab lma3loma (objet:signUpRequest ) we seftha service

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
}
