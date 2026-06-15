package com.gestioncompetition.service;

import com.gestioncompetition.dto.RespoDto;

import java.util.List;

public interface RespoService {
    RespoDto createRespo(RespoDto respoDto);

    RespoDto getRespoById(Long respoId);

    List<RespoDto> getAllRespos();

    RespoDto updateRespo(Long respoId, RespoDto updatedRespo);

    void deleteRespo(Long respoId);

}