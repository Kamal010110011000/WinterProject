package com.question4all.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question4all.model.Users;
import com.question4all.service.UserDataSave;

@RestController
public class SignupData {
	
	@Autowired
	UserDataSave userDataSave;
	
	@PostMapping(value="/signup/savedata")
	public String saveData(@ModelAttribute("users") Users user ) {
		userDataSave.saveUsers(user);
		return "Data Saved";
	}
	
	@GetMapping(value="/show")
	public List<String> showData(Users user){
		
		return userDataSave.findAllEmailid();
	}

}
