package com.question4all.repository;

import org.springframework.data.repository.CrudRepository;

import com.question4all.model.Messages;

public interface MessagesRepository extends CrudRepository<Messages,Long>{

}
