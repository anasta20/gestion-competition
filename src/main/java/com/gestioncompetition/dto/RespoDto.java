package com.gestioncompetition.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespoDto {// DATA TRANSFER OBJECT ()


    private Long id;
    private String firstName;
    private String lastName;// data iwant to transfer between different parts of the application
    private String email;
}