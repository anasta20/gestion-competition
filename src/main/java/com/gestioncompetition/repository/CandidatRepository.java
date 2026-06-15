package com.gestioncompetition.repository;

import com.gestioncompetition.entity.Candidat;
import com.gestioncompetition.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat,Long> {

    Optional<Candidat> findByEmail(String email);//Array

    Candidat findByRole(Role role);
}
