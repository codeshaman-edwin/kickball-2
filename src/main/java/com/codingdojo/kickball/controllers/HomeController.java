package com.codingdojo.kickball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.kickball.models.Team;
import com.codingdojo.kickball.models.User;
import com.codingdojo.kickball.services.TeamService;
import com.codingdojo.kickball.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	TeamService teams;
	@Autowired
	UserService users;
	@Autowired
	HttpSession session;
	
	@GetMapping("/team/form")
	public String teamForm(@ModelAttribute("team") Team team) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		return "teamform.jsp";
	}
	
	@PostMapping("/create/team")
	public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "teamform.jsp";
		}
		else {
			User user = users.getUserById(userId);
			team.setUser(user);
			teams.newTeam(team);
		}
		return "redirect:/homepage";
	}
	
	@GetMapping("/view/team/{id}")
	public String viewTeam(@PathVariable("id") Long id, Model model) {
		model.addAttribute("team", teams.findTeam(id));
		return "viewteam.jsp";
	}
	
	@DeleteMapping("/delete/team/{id}")
	public String deleteTeam(@PathVariable("id") Long id) {
		teams.deleteTeam(id);
		return "redirect:/homepage";
	}
	
	@GetMapping("/edit/team/{id}")
	public String editTeam(@PathVariable("id") Long id, Model model) {
		model.addAttribute("team", teams.findTeam(id));
		return "editteam.jsp";
	}
	
	@PutMapping("/update/team/{id}")
	public String updateTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model, @PathVariable("id") Long id) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			//model.addAttribute("team", teams.findTeam(id));
			return "editteam.jsp";
		}else {
			User user = users.getUserById(userId);
			team.setUser(user);
			teams.updateTeam(team); //?
			return "redirect:/homepage";
		}
	}
	
}

