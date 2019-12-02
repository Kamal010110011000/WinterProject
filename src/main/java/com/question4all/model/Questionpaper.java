package com.question4all.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Questionpaper {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	private String filepath;
	
	@NotNull
	private String topic;
	
	

	public Questionpaper(long id, @NotNull String course, @NotNull String branch, @NotNull int semester,
			@NotNull String subject, @NotNull String filepath, @NotNull String topic) {
		super();
		this.id = id;
		this.course = course;
		this.branch = branch;
		this.semester = semester;
		this.subject = subject;
		this.filepath = filepath;
		this.topic = topic;
	}
	public Questionpaper() {}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	
	
}
