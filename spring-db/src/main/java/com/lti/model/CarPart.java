package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_carPart")
public class CarPart {
	@Id
	private int partno;
	
	@Column(name = "part_name")
	private String partName;
	
	@Column(name = "car_model")
	private String carModel;
	
	
	private double price;
	private int quantity;
	public int getPartno() {
		return partno;
	}
	public void setPartno(int partno) {
		this.partno = partno;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}