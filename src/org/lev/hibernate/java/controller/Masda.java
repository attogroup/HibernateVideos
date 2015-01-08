package org.lev.hibernate.java.controller;

import javax.persistence.Entity;

import org.lev.hibernate.java.model.Car;

@Entity
public class Masda extends Car {

	private String masdaModel;

	public String getMasdaModel() {
		return masdaModel;
	}

	public void setMasdaModel(String masdaModel) {
		this.masdaModel = masdaModel;
	}
	
}
