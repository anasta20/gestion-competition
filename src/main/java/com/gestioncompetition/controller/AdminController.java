package com.gestioncompetition.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin") // mapping global (url global for admin )
@RequiredArgsConstructor
public class AdminController {

    @GetMapping // we don't need other url because we have only one function but if we have more function we need to add more url
    public ResponseEntity<String> sayHello(){return ResponseEntity.ok("hi admin");}
}
