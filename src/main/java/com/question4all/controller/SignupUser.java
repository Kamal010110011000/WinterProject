package com.question4all.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.question4all.model.Users;
import com.question4all.service.AuthUserService;
import com.question4all.service.UserDataSave;

@Controller
public class SignupUser {
	
	@Autowired
	UserDataSave userDataSave;
	
	@Autowired
	AuthUserService authUserService;
	
	
	
	
	
	
	@PostMapping(value="/signup/saved")
	public String SaveData(Model model,@ModelAttribute("user") Users user) {
		List<String> email=userDataSave.findAllEmailid();
		
		if(email.contains(user.getEmailid())){
			model.addAttribute("MODE", "EXISTS");
			return "signup";
		}
		userDataSave.saveUsers(user);
		
		authUserService.saveAuthUser(user.getId(), 3);
		
		model.addAttribute("MODE", "SAVED");
		return "signup";
	}

}
