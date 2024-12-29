package com.songhub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="user_id")
	private int id;

	@Column(name = "name")
	@NotEmpty
	private String name;

	@Column(name = "email")
	@NotEmpty
	private String email;

	@Column(name = "password")
	@NotEmpty
	private String password;

	@Column(name = "role")
	@NotEmpty
	private String role;

	@Column(name = "gender")
	@NotEmpty
	private String gender;

	@Column(name = "premium")
	private boolean premium;
	
	private int age;
	private String referrer;
	private String address;

	public User() {
		super();
	}

	public User(int id, String name, String email, String password, String role, String gender, boolean premium, int age, 
			String referrer, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.gender = gender;
		this.premium = premium;
		this.age=age;
		this.referrer=referrer;
		this.address=address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

}
