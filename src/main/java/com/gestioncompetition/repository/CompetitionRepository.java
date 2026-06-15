package com.gestioncompetition.repository;

import com.gestioncompetition.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition ,Long> {

}
