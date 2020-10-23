package com.BookSouls.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	
	@Id
	  private String id;

	  @NotBlank
	  @Size(max = 20)
	  private String username;

	  @NotBlank
	  @Size(max = 50)
	  @Email
	  private String email;

	  @NotBlank
	  @Size(max = 120)
	  private String password;
	  
	  private String phoneNum;
	  
	  private String image;
	  
	  private Set<String> updateroles;
	  
	  private String address;

	  public Set<String> getUpdateroles() {
		return updateroles;
	}

	public void setUpdateroles(Set<String> updateroles) {
		this.updateroles = updateroles;
	}

	@DBRef
	  private Set<Role> roles = new HashSet<>();

	public User(String username, String email,String password, String address, String phoneNum,String image) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNum = phoneNum;
		this.image = image;
	}

	public User() {
	}

	public String getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	

	  

}
