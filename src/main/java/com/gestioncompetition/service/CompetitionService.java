package com.gestioncompetition.service;

import com.gestioncompetition.dto.CompetitionDto;

import java.util.List;

public interface CompetitionService {
    CompetitionDto createCompetition(CompetitionDto competitionDto);

    CompetitionDto getCompetitionById(Long competitionId);

    List<CompetitionDto> getAllCompetitions();

    CompetitionDto updateCompetition(Long competitionId, CompetitionDto updatedCompetition);

    void deleteCompetition(Long competitionId);

    // ...

   // void inscrireGroupeACompetition(Long groupId, Long competitionId);

    void inscrireGroupeACompetition(Long competitionId, String groupName);

    // void desinscrireGroupeDeCompetition(Long groupId, Long competitionId,String groupName);

//...

}