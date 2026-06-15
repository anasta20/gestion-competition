package com.gestioncompetition.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
@Entity
@Table(name = "competitions")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_id")
    private Long id;

    @Column(name = "competition_name")
    private String competitionName;

    @Column(name = "competition_description")
    private String competitionDescription;

    @Temporal(TemporalType.TIMESTAMP)//both date and time
    @Column(name = "competition_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date competitionDate;

    @OneToMany(mappedBy = "competition")
    private List<Groupe> groups = new ArrayList<>();
}