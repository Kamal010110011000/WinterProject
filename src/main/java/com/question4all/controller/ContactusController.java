package com.question4all.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.question4all.model.Messages;
import com.question4all.service.MessageService;

@Controller
public class ContactusController {
	
	@Autowired
	MessageService messageService;
	
	

	@PostMapping(value="contactus/send")
	public String dataSend(Model model,@RequestParam("firstname")String firstname,@RequestParam("lastname")String lastname,@RequestParam("emailid")String emailid,@RequestParam("message")String message) {
		model.addAttribute("MODE", "DATASEND");
		Messages messages=new Messages();;
		messages.setName(firstname+" "+lastname);
		messages.setEmailid(emailid);
		messages.setMessage(message);
		messages.setStatus(false);
		
		
		messageService.sendMessage(messages);
		
		return "contactus";
	}
}
