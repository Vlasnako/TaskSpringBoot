package com.vlasnakonechnyi.testproject.testproject.dao;

import com.vlasnakonechnyi.testproject.testproject.entity.Customer;

import java.util.List;

public interface CustomerDao {
    Customer createCustomer(Customer customer);

    List<Customer> getCustomers();

    Customer getCustomerById(long id);

    Customer updateCustomer(Customer customer);

    boolean existsByEmail(String email);
}
