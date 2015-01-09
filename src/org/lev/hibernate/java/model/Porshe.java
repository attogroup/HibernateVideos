package org.lev.hibernate.java.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Porshe_class")
public class Porshe extends Car {

	private String porsheModel;

	public String getPorsheModel() {
		return porsheModel;
	}

	public void setPorsheModel(String porsheModel) {
		this.porsheModel = porsheModel;
	}
	
}
