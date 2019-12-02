package com.question4all.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AuthUser implements Serializable{

	@Column(name="id")
	private long id;
	@Column(name="auth_role_id")
	private int auth_role_id;
	
	public AuthUser() {}
	
	public AuthUser(long id,int auth_role_id) {
		this.id=id;
		this.auth_role_id=auth_role_id;
	}
	
	
}
