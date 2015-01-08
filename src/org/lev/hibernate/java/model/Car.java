package org.lev.hibernate.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Car implements MyData{
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int carsId;
	@Column
	private String carName;
	@Column
	private int carYear;
	
	@ManyToOne 
	@JoinColumn(name="userID")
	private User userCarOwner;
	

	public int getCarsId() {
		return carsId;
	}
	public void setCarsId(int carsId) {
		this.carsId = carsId;
	}
	public User getUserCarOwner() {
		return userCarOwner;
	}
	public void setUserCarOwner(User userCarOwner) {
		this.userCarOwner = userCarOwner;
	}
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}

}
