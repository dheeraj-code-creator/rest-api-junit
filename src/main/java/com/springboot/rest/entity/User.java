package com.springboot.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {

	@Id
	@Column
	private String userId;
	
	@Column
	private String userName;
	
	public User() {
		
	}
	
	public User(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(userId, user.userId) && Objects.equals(userName, user.userName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, userName);
	}

	@Override
	public String toString() {
		return "User{" +
				"userId='" + userId + '\'' +
				", userName='" + userName + '\'' +
				'}';
	}
}
