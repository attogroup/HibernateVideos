package org.lev.hibernate.java.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name= "Classes",
		discriminatorType=DiscriminatorType.STRING
		)
public class Car implements MyData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carsId;
	@Column
	private String carName;
	@Column
	private int carYear;



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
