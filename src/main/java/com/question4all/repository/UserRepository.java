package com.question4all.repository;




import org.springframework.data.repository.CrudRepository;

import com.question4all.model.Users;

public interface UserRepository extends CrudRepository<Users, Long> {	
	

}
