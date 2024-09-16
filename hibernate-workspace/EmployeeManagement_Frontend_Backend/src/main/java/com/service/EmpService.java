package com.service;

import java.util.List;

import com.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpService {

	 private EntityManagerFactory entityManagerFactory;

	    public EmpService() {
	        entityManagerFactory = Persistence.createEntityManagerFactory("abhisek");
	    }

	    public int createEmployee(Employee employee) {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        entityManager.getTransaction().begin();
	        entityManager.persist(employee);
	        entityManager.getTransaction().commit();
	        return 1;
	    }

	    public int updateEmployee(Employee employee) {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        entityManager.getTransaction().begin();
	        entityManager.merge(employee);
	        entityManager.getTransaction().commit();
	        return 1;
	    }

	    public int deleteEmployee(int id) {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        entityManager.getTransaction().begin();
	        Employee employee = entityManager.find(Employee.class, id);
	        if (employee != null) {
	            entityManager.remove(employee);
	        }
	        entityManager.getTransaction().commit();
	        return 1;
	    }

	    public List<Employee> fetchAllEmployees() {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        entityManager.getTransaction().begin();
	        List<Employee> employees = entityManager.createQuery("from Employee", Employee.class).getResultList();
	        entityManager.getTransaction().commit();
	        return employees;
	    }

	    public void closeSession() {
	        entityManagerFactory.close();
	    }
	
}
