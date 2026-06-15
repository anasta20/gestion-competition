package com.gestioncompetition.service.impl;

import com.gestioncompetition.dto.RespoDto;
import com.gestioncompetition.entity.Respo;
import com.gestioncompetition.exceptions.ResourceNotFoundException;
import com.gestioncompetition.mapper.RespoMapper;
import com.gestioncompetition.repository.RespoRepository;
import com.gestioncompetition.service.RespoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RespoServiceImpl  implements RespoService {

    private RespoRepository respoRepository ;

    @Override
    public RespoDto createRespo(RespoDto respoDto)  { // respoDto passed as a parameter because its data that comes from an external source
        Respo respo = RespoMapper.mapToRespo(respoDto);// this step takes data from respodta object and filling the correspondinf fields in the respo entity
//This step is necessary because you typically want to persist the data in a database, and entities are often used for that purpose.
        Respo savedrespo = respoRepository.save(respo);// save to database
        return RespoMapper.mapToRespoDto(savedrespo);// to send a response (object)

    }
    @Override
    public RespoDto getRespoById(Long respoId) {
        Respo respo = respoRepository.findById(respoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Respo is not exists with given id : " + respoId));

        return RespoMapper.mapToRespoDto(respo);
    }

    @Override
    public List<RespoDto> getAllRespos() {
        List<Respo> respos = respoRepository.findAll();
        return respos.stream().map((respo) -> RespoMapper.mapToRespoDto(respo))
                .collect(Collectors.toList());
    }

    @Override
    public RespoDto updateRespo(Long respoId, RespoDto updatedRespo) {

        Respo respo = respoRepository.findById(respoId).orElseThrow(
                () -> new ResourceNotFoundException("Respo is not exists with given id: " + respoId)
        );

        respo.setFirstName(updatedRespo.getFirstName());
        respo.setLastName(updatedRespo.getLastName());
        respo.setEmail(updatedRespo.getEmail());

        Respo updatedRespoObj = respoRepository.save(respo);

        return RespoMapper.mapToRespoDto(updatedRespoObj);
    }

    @Override
    public void deleteRespo(Long respoId) {
        respoRepository.deleteById(respoId);
}

}