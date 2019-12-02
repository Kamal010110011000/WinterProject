package com.question4all.repository;

import org.springframework.data.repository.CrudRepository;

import com.question4all.model.AuthUserRole;
import com.question4all.model.AuthUser;

public interface AuthUserRepository extends CrudRepository<AuthUserRole,AuthUser>{
	

}
