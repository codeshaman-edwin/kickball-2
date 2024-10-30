package com.codingdojo.kickball.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "teams")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Name is required")
	@Size(min = 3, max = 100, message = "name must be between 3 and 100 characters")
	private String name;
	
	//@NotEmpty(message = "Skill Level is required")
	@NotNull
	@Min(value = 1, message = "can't be lower than 1")
	@Max(value = 5, message = "can't be higher than 5")
	private Integer skill;
	
	@NotEmpty(message = "Game Day is required")
	@Size(min = 3, max = 100, message = "Game Day must be between 3 and 100 characters")
	private String gameday;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Team() {
		
	}
	
	public Team(
			@NotEmpty(message = "name is required") @Size(min = 3, max = 30, message = "name must be between 3 and 30 characters") String name,
			@NotEmpty(message = "skill is required") @Size(min = 3, max = 30, message = "skill must be between 3 and 30 characters") Integer skill,
			@NotEmpty(message = "gameday is required") @Size(min = 3, max = 255, message = "gameday must be between 3 and 255 characters") String gameday,
			User user) {
		
		this.name = name;
		this.skill = skill;
		this.gameday = gameday;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSkill() {
		return skill;
	}

	public void setSkill(Integer skill) {
		this.skill = skill;
	}

	public String getGameday() {
		return gameday;
	}

	public void setGameday(String gameday) {
		this.gameday = gameday;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}

