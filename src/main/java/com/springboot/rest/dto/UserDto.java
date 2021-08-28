package com.springboot.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto{
	
	@JsonProperty(value = "userId")
	private String userId;
	
	@JsonProperty(value = "userName")
	private String userName;

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


}
