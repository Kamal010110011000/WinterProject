package com.question4all.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.question4all.model.Users;
import com.question4all.service.UserDataSave;


@Controller
public class AdminDashbord {
	
	@Autowired
	UserDataSave userDataSave;
	
	Users user;
	
	@RequestMapping(value="/admin")
	public String adminDashboard(Model model,Principal principal) {
		model.addAttribute("USER", principal.getName());
		List<Users> userList=userDataSave.showAllUsers(user);
		model.addAttribute("userList", userList);
		model.addAttribute("CONTANT", "DATASHOW");
		return "index";
	}
	
	@RequestMapping(value="/admin/addquestion")
	public String questionAdd(Model model) {
		
		model.addAttribute("CONTANT", "QUESTION");
		
		return "index";
	}

}
