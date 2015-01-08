package org.lev.hibernate.java.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Car implements MyData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carsId;
	@Column
	private String carName;
	@Column
	private int carYear;

	@ManyToMany
	@JoinTable(name = "contracts", joinColumns = @JoinColumn(name = "carID"), inverseJoinColumns = @JoinColumn(name = "userID"))
	private Collection<User> users = new ArrayList<User>();

	public int getCarsId() {
		return carsId;
	}

	public void setCarsId(int carsId) {
		this.carsId = carsId;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
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
