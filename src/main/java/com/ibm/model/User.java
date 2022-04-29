package com.ibm.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.UniqueElements;


@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	long id;
		String name,email,password,	created_at, login_token,
		type,
		address,
		is_email_verified;
	@Column(unique = true)
	String loginID;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getLogin_token() {
		return login_token;
	}
	public void setLogin_token(String login_token) {
		this.login_token = login_token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getIs_email_verified() {
		return is_email_verified;
	}
	public void setIs_email_verified(String is_email_verified) {
		this.is_email_verified = is_email_verified;
	}
	public User(long id, String name, String email, String password, String created_at, String login_token, String type,
			String address, String is_email_verified, String loginID) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.created_at = created_at;
		this.login_token = login_token;
		this.type = type;
		this.address = address;
		this.is_email_verified = is_email_verified;
		this.loginID = loginID;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long id, String name, String password, @UniqueElements String loginID) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.loginID = loginID;
	}
	
	
	
}