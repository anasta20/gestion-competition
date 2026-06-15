package com.gestioncompetition.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/comiteOrganisation")
@RequiredArgsConstructor
public class ComiteOrganisationController {

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hi comité d'organisation");
    }
}
