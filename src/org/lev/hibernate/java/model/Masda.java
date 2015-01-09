package org.lev.hibernate.java.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Masda_class")
public class Masda extends Car {

	private String masdaModel;

	public String getMasdaModel() {
		return masdaModel;
	}

	public void setMasdaModel(String masdaModel) {
		this.masdaModel = masdaModel;
	}
	
}
