package org.lev.hibernate.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Car implements MyData{
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int carsId;
	@Column
	private String carName;
	@Column
	private String carYear;
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarYear() {
		return carYear;
	}
	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}

}
