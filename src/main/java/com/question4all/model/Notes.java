package com.question4all.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Notes {

	@Id
	@GeneratedValue
	private long id;
	@NotNull
	private String course;
	@NotNull
	private String branch;
	@NotNull
	private int semester;
	@NotNull
	private String subject;
	@NotNull
	private String notesPath;
	
	
}
