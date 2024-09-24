package com.vlasnakonechnyi.testproject.testproject.dao;

import com.vlasnakonechnyi.testproject.testproject.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImplementation implements CustomerDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void createCustomer(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        Session session = entityManager.unwrap(Session.class);
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        return query.getResultList();
    }
}
