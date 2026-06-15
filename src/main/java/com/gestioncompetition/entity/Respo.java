package com.gestioncompetition.entity;


import jakarta.persistence.*; // necessary annotations for JPA
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//lombok for automatically generating code such as getters setters ....
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity//Marks this class as a JPA entity ()
@Table(name = "responsables")// table name for the database table to which this entity is mapped

public class Respo {

    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto increm
    private Long id;

    @Column(name = "first_name")//Specifies the mapping between the entity attribute and the database column.
    private String firstName;

    @Column(name = "last_name")// in this case firstname attribute is mapped to first_name column in the table
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;


}