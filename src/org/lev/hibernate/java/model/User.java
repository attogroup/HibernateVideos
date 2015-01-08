package org.lev.hibernate.java.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.java.lev.myproject.Address;

@Entity
public class User implements MyData{
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column
	private String userName;

    @ManyToMany(cascade={CascadeType.ALL},mappedBy="users")
	private Collection<Car> cars = new ArrayList<Car>();
    
	@Embedded
	private Address address;


	
	public Collection<Car> getCars() {
		return cars;
	}

	public void setCars(Collection<Car> cars) {
		this.cars = cars;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "user_age")
	private int userAge;

	@Temporal(value = TemporalType.DATE)
	private Date dateOfBirth;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

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

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

}
