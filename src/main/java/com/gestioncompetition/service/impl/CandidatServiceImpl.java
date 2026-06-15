package com.gestioncompetition.service.impl;

import com.gestioncompetition.repository.CandidatRepository;
import com.gestioncompetition.service.CandidatService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidatServiceImpl implements CandidatService {

    private  final CandidatRepository candidatRepository;

    @Override // extand + modification de return
    public UserDetailsService userDetailsService(){
        return new UserDetailsService(){
            @Override
            public UserDetails loadUserByUsername(String username){
                return candidatRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Candidat not found"));
            }
        };
    }
}
