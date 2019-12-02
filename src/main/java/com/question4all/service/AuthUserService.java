package com.question4all.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question4all.model.AuthUser;
import com.question4all.model.AuthUserRole;
import com.question4all.repository.AuthUserRepository;

@Service
@Transactional
public class AuthUserService {
	
	@Autowired
	private AuthUserRepository authUserRepository;
	
	public AuthUserService(){
		
	}
	
	public AuthUserService(AuthUserRepository authUserRepository) {
		this.authUserRepository=authUserRepository;
	}
	
	public AuthUserRole saveAuthUser(long id,int auth_role_id) {
		AuthUserRole authUserRole=new AuthUserRole();
		authUserRole.setAuth(new AuthUser(id,auth_role_id));
		
		return authUserRepository.save(authUserRole);
		
	}

}
