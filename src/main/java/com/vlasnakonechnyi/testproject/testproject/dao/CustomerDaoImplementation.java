package com.vlasnakonechnyi.testproject.testproject.dao;

import com.vlasnakonechnyi.testproject.testproject.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
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
    public Customer createCustomer(Customer customer) {
        if (existsByEmail(customer.getEmail())) {
            return null;
        }
        customer.setCreated((int) System.currentTimeMillis());
        Session session = entityManager.unwrap(Session.class);
        session.persist(customer);
        return customer;
    }


    @Override
    public List<Customer> getCustomers() {
        Session session = entityManager.unwrap(Session.class);
        Query<Customer> query = session.createQuery("from Customer where isActive = true", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer getCustomerById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Customer> query = session.createQuery("from Customer where isActive= true and id =" + id, Customer.class);
        return query.getSingleResultOrNull();
    }

    @Transactional
    @Override
    public Customer updateCustomer(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        customer.setUpdated((int) System.currentTimeMillis());
        session.merge(customer);
        return customer;
    }

    @Override
    public boolean existsByEmail(String email) {
        Session session = entityManager.unwrap(Session.class);
        Query<Long> query = session.createQuery("SELECT count(c) FROM Customer c WHERE c.email = :email", Long.class);
        query.setParameter("email", email);
        Long count = query.uniqueResult();
        return count > 0;
    }
}
