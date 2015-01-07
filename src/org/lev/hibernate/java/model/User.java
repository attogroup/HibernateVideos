package org.lev.hibernate.java.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.java.lev.myproject.Address;

@Entity(name = "User_model_next2")
public class User {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	// @Transient
	@Column
	private String userName;

	@Embedded
	private Address address;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "All_adresses", joinColumns = @JoinColumn(name = "ID_link"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name = "user_Adresses_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<Address> userAdressCollection = new ArrayList<Address>();

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "Office_street")),
			@AttributeOverride(name = "house", column = @Column(name = "Office_house")),
			@AttributeOverride(name = "room", column = @Column(name = "Office_room")),
			@AttributeOverride(name = "postCode", column = @Column(name = "Office_postcode"))

	})
	private Address officeAdress;

	public Collection<Address> getUserAdressCollection() {
		return userAdressCollection;
	}

	public void setUserAdressCollection(Collection<Address> userAdressCollection) {
		this.userAdressCollection = userAdressCollection;
	}

	public Address getOfficeAdress() {
		return officeAdress;
	}

	public void setOfficeAdress(Address officeAdress) {
		this.officeAdress = officeAdress;
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
