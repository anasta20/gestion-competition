package com.gestioncompetition.mapper;

import com.gestioncompetition.dto.CompetitionDto;
import com.gestioncompetition.entity.Competition;

public class CompetitionMapper {
    // convert competition jpa entity into competition dto
    public static CompetitionDto mapToCompetitionDto(Competition competition){
        return new CompetitionDto(
                competition.getId(),
                competition.getCompetitionName(),
                competition.getCompetitionDescription(),
                competition.getCompetitionDate(),
                competition.getGroups()
        );
    }

    // convert competition dto into competition jpa entity
    public static Competition mapToCompetition(CompetitionDto competitionDto){
        return new Competition(
                competitionDto.getId(),
                competitionDto.getCompetitionName(),
                competitionDto.getCompetitionDescription(),
                competitionDto.getCompetitionDate(),
                competitionDto.getGroups()

        );
}
}