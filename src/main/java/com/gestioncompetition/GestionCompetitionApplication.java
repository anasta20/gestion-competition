package com.gestioncompetition;

import com.gestioncompetition.entity.Candidat;
import com.gestioncompetition.entity.Role;
import com.gestioncompetition.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@SpringBootApplication
public class GestionCompetitionApplication implements CommandLineRunner {

	@Autowired
	private CandidatRepository candidatRepository;


	public static void main(String[] args) {
		SpringApplication.run(GestionCompetitionApplication.class, args);
	}

	public void  run(String... args){
		Candidat adminAccount = candidatRepository.findByRole(Role.Admin);
		if(adminAccount==null){
			Candidat candidat = new Candidat();

			//candidat.setId("1");
			candidat.setEmail("admin@gmail.com");
			candidat.setSexe("M");
			candidat.setPrenom("admin");
			candidat.setNom("admin");
			candidat.setRole(Role.Admin);
			candidat.setPassword(new BCryptPasswordEncoder().encode("admin"));

			candidatRepository.save(candidat);
		}
	}

}
