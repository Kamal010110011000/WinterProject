package com.question4all.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login/error",method=RequestMethod.GET)
	public String loginError(Model model) {
		model.addAttribute("MODE", "WORNG PASSWORD OR EMAIL");
		return "login";
	}

}
