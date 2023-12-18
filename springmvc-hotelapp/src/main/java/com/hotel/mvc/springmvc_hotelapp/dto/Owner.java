package com.hotel.mvc.springmvc_hotelapp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "owner")
	private List<FoodProduct> product;
	
	@OneToMany
	private List<Worker> workers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<FoodProduct> getProduct() {
		return product;
	}

	public void setProduct(List<FoodProduct> product) {
		this.product = product;
	}
}
