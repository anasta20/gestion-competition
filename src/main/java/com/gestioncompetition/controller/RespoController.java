package com.gestioncompetition.controller;

import com.gestioncompetition.dto.RespoDto;
import com.gestioncompetition.service.RespoService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/responsable")  // Change request mapping
public class RespoController {

    private RespoService respoService;  // Change service

    // Build Add Respo REST API
    @PostMapping
    public ResponseEntity<RespoDto> createRespo(@RequestBody RespoDto respoDto){
        // System.out.println("Received request at path: /api/respos");
        RespoDto savedRespo = respoService.createRespo(respoDto);
        return new ResponseEntity<>(savedRespo, HttpStatus.CREATED);
    }

    // Build Get Respo REST API
    @GetMapping("{id}")
    public ResponseEntity<RespoDto> getRespoById(@PathVariable("id") Long respoId){
        RespoDto respoDto = respoService.getRespoById(respoId);
        return ResponseEntity.ok(respoDto);
    }

    // Build Get All Respos REST API
    @GetMapping
    public ResponseEntity<List<RespoDto>> getAllRespos(){
        List<RespoDto> respos = respoService.getAllRespos();
        return ResponseEntity.ok(respos);
    }

    // Build Update Respo REST API
    @PutMapping("{id}")
    public ResponseEntity<RespoDto> updateRespo(@PathVariable("id") Long respoId,
                                                @RequestBody RespoDto updatedRespo){
        RespoDto respoDto = respoService.updateRespo(respoId, updatedRespo);
        return ResponseEntity.ok(respoDto);
    }

    // Build Delete Respo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRespo(@PathVariable("id") Long respoId){
        respoService.deleteRespo(respoId);
        return ResponseEntity.ok("Respo deleted successfully!");
}



}
