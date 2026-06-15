package com.gestioncompetition.service.impl;

import com.gestioncompetition.dto.CompetitionDto;
import com.gestioncompetition.entity.Competition;
import com.gestioncompetition.entity.Groupe;
import com.gestioncompetition.exceptions.ResourceNotFoundException;
import com.gestioncompetition.mapper.CompetitionMapper;
import com.gestioncompetition.repository.CompetitionRepository;
import com.gestioncompetition.repository.GroupeRepository;
import com.gestioncompetition.service.CompetitionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;

    private GroupeRepository groupRepository;

    @Override
    public CompetitionDto createCompetition(CompetitionDto competitionDto) {
        System.out.println("test1");
        Competition competition = CompetitionMapper.mapToCompetition(competitionDto);
        System.out.println("test2");
        Competition savedCompetition = competitionRepository.save(competition);
        System.out.println("test3");
        return CompetitionMapper.mapToCompetitionDto(savedCompetition);
    }

    @Override
    public CompetitionDto getCompetitionById(Long competitionId) {
        Competition competition = competitionRepository.findById(competitionId).orElseThrow(
                () -> new ResourceNotFoundException("Competition does not exist with the given id: " + competitionId)
        );
        return CompetitionMapper.mapToCompetitionDto(competition);
    }

    @Override
    public List<CompetitionDto> getAllCompetitions() {
        List<Competition> competitions = competitionRepository.findAll();
        return competitions.stream().map((competition) -> CompetitionMapper.mapToCompetitionDto(competition))
                .collect(Collectors.toList());
    }

    @Override
    public CompetitionDto updateCompetition(Long competitionId, CompetitionDto updatedCompetition) {
        Competition competition = competitionRepository.findById(competitionId).orElseThrow(
                () -> new ResourceNotFoundException("Competition does not exist with the given id: " + competitionId)
        );

        competition.setCompetitionName(updatedCompetition.getCompetitionName());
        competition.setCompetitionDescription(updatedCompetition.getCompetitionDescription());
        competition.setCompetitionDate(updatedCompetition.getCompetitionDate());

        Competition savedCompetition = competitionRepository.save(competition);

        return CompetitionMapper.mapToCompetitionDto(savedCompetition);
    }

    @Override
    public void deleteCompetition(Long competitionId) {
        competitionRepository.findById(competitionId).orElseThrow(
                () -> new ResourceNotFoundException("Competition does not exist with the given id: " + competitionId)
        );

        competitionRepository.deleteById(competitionId);
}

    @Override
    public void inscrireGroupeACompetition(Long competitionId, String groupName) {
       // Groupe group = groupRepository.findById(groupId)
            //    .orElseThrow(() -> new EntityNotFoundException("Group with id " + groupId + " not found"));

        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new EntityNotFoundException("Competition with id " + competitionId + " not found"));

        // Créer un groupe avec un nom dynamique
        Groupe group = new Groupe();
        group.setGroupName(groupName); // Utilisez le nom dynamique
        group.setCompetition(competition);

        // Ajouter le groupe à la compétition
        //  competition.getGroups().add(group);

        // Sauvegarder la compétition et le groupe
        //competitionRepository.save(competition);
        //groupRepository.save(group);

        // Vérifier si le groupe n'est pas déjà inscrit à la compétition
        if (!competition.getGroups().contains(group)) {
            groupRepository.save(group);
            competition.getGroups().add(group);
            competitionRepository.save(competition);


        }
}
   /* @Override
    public void desinscrireGroupeDeCompetition(Long groupId, Long competitionId, String groupName) {
       // Groupe group = groupRepository.findById(groupId)
            //    .orElseThrow(() -> new EntityNotFoundException("Group with id " + groupId + " not found"));

        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new EntityNotFoundException("Competition with id " + competitionId + " not found"));

        Groupe group = new Groupe();
        group.setGroupName(groupName); // Utilisez le nom dynamique
        group.setCompetition(competition);

        // Vérifier si le groupe est inscrit à la compétition
        if (competition.getGroups().contains(group)) {
            competition.getGroups().remove(group);
            competitionRepository.save(competition);
            groupRepository.save(group);

        }
    }*/
}
