package com.BookSouls.Entity.resposne;

import java.util.List;

public class BasicAuthResponse {
	private String token;
	private String type = "Basic";
	private String id;
	private String username;
	private String address;
	private String phoneNum;
	private String image;
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private String email;
	private List<String> roles;

	public BasicAuthResponse(String basicToken, String id, String username, String email, String address,String phoneNum,String image,List<String> roles) {
		this.token = basicToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.address = address;
		this.phoneNum = phoneNum;
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getBasicToken() {
		return token;
	}

	public void setBasicToken(String basicToken) {
		this.token = basicToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
