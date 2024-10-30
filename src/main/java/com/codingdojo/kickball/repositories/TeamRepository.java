package com.codingdojo.kickball.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.kickball.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long>{
	List<Team> findAll();
}
