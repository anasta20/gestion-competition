package com.gestioncompetition.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groupes")
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupe_id")
    private Long GrId;

    @Column(name = "groupe_name")
    private String groupName;

    // Ajoutez d'autres champs pertinents

    @OneToMany(mappedBy = "groupe")
    private List<Candidat> participants = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;


    // Getters et setters
}
