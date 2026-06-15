package com.gestioncompetition.controller;

import com.gestioncompetition.dto.CompetitionDto;
import com.gestioncompetition.service.CompetitionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/competitions")
public class CompetitionController {

    private final CompetitionService competitionService;

    // Build Create or Add Competition REST API
    @PostMapping
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    public ResponseEntity<CompetitionDto> createCompetition(@RequestBody CompetitionDto competitionDto) {
        System.out.println("test1 - controller");
        CompetitionDto competition = competitionService.createCompetition(competitionDto);
        return new ResponseEntity<>(competition, HttpStatus.CREATED);
    }

    // Build Get Competition REST API
    @GetMapping("{id}")
    public ResponseEntity<CompetitionDto> getCompetitionById(@PathVariable("id") Long competitionId) {
        CompetitionDto competitionDto = competitionService.getCompetitionById(competitionId);
        return ResponseEntity.ok(competitionDto);
    }

    // Build Get All Competitions REST API
    @GetMapping
    public ResponseEntity<List<CompetitionDto>> getAllCompetitions() {
        List<CompetitionDto> competitions = competitionService.getAllCompetitions();
        return ResponseEntity.ok(competitions);
    }

    // Build Update Competition REST API
    @PutMapping("{id}")
    public ResponseEntity<CompetitionDto> updateCompetition(@PathVariable("id") Long competitionId,
                                                            @RequestBody CompetitionDto updatedCompetition) {
        CompetitionDto competitionDto = competitionService.updateCompetition(competitionId, updatedCompetition);
        return ResponseEntity.ok(competitionDto);
    }

    // Build Delete Competition REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCompetition(@PathVariable("id") Long competitionId) {
        competitionService.deleteCompetition(competitionId);
        return ResponseEntity.ok("Competition deleted successfully!.");
}
    @PostMapping("/{competitionId}/inscrire")
    public ResponseEntity<String> inscrireGroupeACompetition(@PathVariable Long competitionId,@RequestBody Map<String, String> requestBody) {

        String groupName = requestBody.get("groupName");
        competitionService.inscrireGroupeACompetition(competitionId,groupName);
        return ResponseEntity.ok("Le groupe a été inscrit à la compétition avec succès.");
}
   // @PostMapping("/{competitionId}/desinscrire/{groupId}")
   // public ResponseEntity<String> desinscrireGroupeDeCompetition(@PathVariable Long competitionId, @PathVariable Long groupId,@PathVariable String groupName) {
      //  competitionService.desinscrireGroupeDeCompetition(groupId, competitionId,groupName);
       // return ResponseEntity.ok("Le groupe a été désinscrit de la compétition avec succès.");
//}
}