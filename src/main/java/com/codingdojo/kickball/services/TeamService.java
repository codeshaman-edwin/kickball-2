package com.codingdojo.kickball.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.kickball.models.Team;
import com.codingdojo.kickball.repositories.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	TeamRepository tRepo;
	
	public List<Team> allTeams(){
		return tRepo.findAll();
	}
	
	public Team newTeam(Team book) {
		return tRepo.save(book);
	}
	
	public Team findTeam(Long id) {
		Optional<Team> book = tRepo.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			return null;
		}
	}
	
	public void deleteTeam(Long id) {
		tRepo.deleteById(id);
	}
	
	public Team updateTeam(Team book) {
		return tRepo.save(book);
	}
	
}

