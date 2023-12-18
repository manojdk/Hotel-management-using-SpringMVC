package com.hotel.mvc.springmvc_hotelapp.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hotel.mvc.springmvc_hotelapp.dto.FoodOrder;

@Repository
public class FoodOrderDaoImpl {
	EntityManager entityManager = Factory.getEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public String saveOrder(FoodOrder order) {
		entityTransaction.begin();
		entityManager.persist(order);
		entityTransaction.commit();
		
		return order.getCustomerName()+ " 's order is saved";
		
	}
	
	public FoodOrder getOrder(int id) {
		return entityManager.find(FoodOrder.class,id);
	}
	
	public ArrayList<FoodOrder> getAllOrder(){
		Query q = entityManager.createQuery("select o from FoodOrder o");
		return (ArrayList<FoodOrder>) q.getResultList();
	}
}
