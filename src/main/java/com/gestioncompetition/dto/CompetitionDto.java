package com.gestioncompetition.dto;

import com.gestioncompetition.entity.Groupe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionDto {
    private Long id ;
    private String competitionName;
    private String competitionDescription;
    private Date competitionDate;
    private List<Groupe> groups;
}
