package com.vlasnakonechnyi.testproject.testproject.dao;

import com.vlasnakonechnyi.testproject.testproject.entity.Customer;

import java.util.List;

public interface CustomerDao {
    void createCustomer(Customer customer);
    List<Customer> getCustomers();
}
