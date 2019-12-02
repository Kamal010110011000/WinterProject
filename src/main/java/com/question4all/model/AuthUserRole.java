package com.question4all.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="auth_user_role")
public class AuthUserRole {

	@EmbeddedId
	private AuthUser auth;

	public AuthUser getAuth() {
		return auth;
	}

	public void setAuth(AuthUser auth) {
		this.auth = auth;
	}
	
	
	
	
	
}
