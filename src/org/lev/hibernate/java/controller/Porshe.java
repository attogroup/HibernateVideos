package org.lev.hibernate.java.controller;

import javax.persistence.Entity;

import org.lev.hibernate.java.model.Car;

@Entity
public class Porshe extends Car {

	private String porsheModel;

	public String getPorsheModel() {
		return porsheModel;
	}

	public void setPorsheModel(String porsheModel) {
		this.porsheModel = porsheModel;
	}
	
}
