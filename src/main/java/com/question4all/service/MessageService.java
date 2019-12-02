package com.question4all.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question4all.model.Messages;
import com.question4all.repository.MessagesRepository;

@Service
public class MessageService {

	@Autowired
	MessagesRepository messagesRepository;
	
	public void sendMessage(Messages message) {
		messagesRepository.save(message);
	}
	
	public List<Messages> getAllMessages(){
		return (List<Messages>) messagesRepository.findAll();	
	}
	
	public List<Messages> getNewMessages(){
		
		List<Messages> message=new ArrayList<>();
		for(Messages mess:getAllMessages()) {
			if(!mess.isStatus()) {
				message.add(mess);
			}
		}
		return message;
	}
}
