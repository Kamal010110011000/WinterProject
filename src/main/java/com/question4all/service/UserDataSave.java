package com.question4all.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.question4all.model.Users;
import com.question4all.repository.UserRepository;

@Service
@Transactional
public class UserDataSave {
	
	private UserRepository userRepository;
	
	public UserDataSave(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
		
	public void saveUsers(Users user) {
		
		userRepository.save(user);
		
	}
	
	public List<String> findAllEmailid(){
		Iterable<Users> userData=new ArrayList<Users>();
		List<String> allEmailid=new ArrayList<>();
		userData=userRepository.findAll();
		for(Users u:userData) {
			allEmailid.add(u.getEmailid());
		}
		return allEmailid;
	}
	
	public List<Users> showAllUsers(Users user){
		
	return (List<Users>) userRepository.findAll();
	
	}

}
