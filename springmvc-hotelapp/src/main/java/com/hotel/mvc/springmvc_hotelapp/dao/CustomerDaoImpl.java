package com.hotel.mvc.springmvc_hotelapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

import com.hotel.mvc.springmvc_hotelapp.dto.Customer;

@Repository
public class CustomerDaoImpl {
	EntityManager entityManager = Factory.getEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public String saveCustomer(Customer customer) {
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();

		return customer.getCustomer() + " is saved";
	}

	public Customer getCustomer(int id) {
		return entityManager.find(Customer.class,id);
	}
	
}
