package com.gestioncompetition.mapper;

import com.gestioncompetition.dto.RespoDto;
import com.gestioncompetition.entity.Respo;
// two static methods to mapp between respo entities and respodto objects
//
public class RespoMapper {


    public static RespoDto mapToRespoDto(Respo respo){
        return new RespoDto(
                respo.getId(),
                respo.getFirstName(),
                respo.getLastName(),
                respo.getEmail()
        );
    }

    public static Respo mapToRespo(RespoDto respoDto){
        return new Respo(
                respoDto.getId(),
                respoDto.getFirstName(),
                respoDto.getLastName(),
                respoDto.getEmail()
        );
    }
}
// DTO will be used to transform data between layers /rendering http request