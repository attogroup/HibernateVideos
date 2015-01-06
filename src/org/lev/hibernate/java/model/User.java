package org.lev.hibernate.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "User_model")
public class User {
	private int userId;
	private String userName;
	private int userAge;

	@Id
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_age")
	public int getUserAge() {
		return (userAge + 100);
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

}
