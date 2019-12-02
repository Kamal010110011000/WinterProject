package com.question4all.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePage {
	
	@RequestMapping(value="/")
	public String homePage(Model model,Principal principal) {
		try {
			if(principal.getName()!=null) {
				
				model.addAttribute("USER", principal.getName());
				model.addAttribute("MODE","USER");
				return "home";
			}
			}
			catch (NullPointerException npx){
				
				
			
			}
		model.addAttribute("MODE", "HOME");
		return "home";
	}
	@RequestMapping(value="/avatar.png")
	public String userPage(Model model,Principal principal) {
		try {
			if(principal.getName()!=null) {
				
				model.addAttribute("USER", principal.getName());
				model.addAttribute("MODE","USER");
				return "home";
			}
			}
			catch (NullPointerException npx){
				
				
			
			}
		model.addAttribute("MODE", "HOME");
		return "home";
	}
	
	
	
	@RequestMapping(value="/questionpapers")
	public String questions(Model model,Principal principal) {
		
		try {
			if(principal.getName()!=null) {
				
				model.addAttribute("USER", principal.getName());
				model.addAttribute("MODE","USER");
				return "questionpaper";
			}
			}
			catch (NullPointerException npx){
				
				
			
			}
		return "home";
	}
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String userLogin(Model model,Principal principal) {
		try {
			if(principal.getName()!=null) {
				
				model.addAttribute("USER", principal.getName());
				model.addAttribute("MODE","USER");
				return "home";
			}
			}
			catch (NullPointerException npx){
				
				
			
			}
		return "adminlogin";
	}
	
	@RequestMapping(value="/signup")
	public String signUp(Model model,Principal principal) {
		try {
			if(principal.getName()!=null) {
				
				model.addAttribute("USER", principal.getName());
				model.addAttribute("MODE","USER");
				return "home";
			}
			}
			catch (NullPointerException npx){
				
				
			
			}
		return "signup";
	}
	
	@RequestMapping(value="/contactus")
	public String contactUs(Model model,Principal principal) {
		try {
			if(principal.getName()!=null) {
				
				model.addAttribute("USER", principal.getName());
				model.addAttribute("MODE","USER");
				return "contactus";
			}
			}
			catch (NullPointerException npx){
				
				
			
			}
		
		return "contactus";
	}
	
}
