package com.vlasnakonechnyi.testproject.testproject.service;

import com.vlasnakonechnyi.testproject.testproject.entity.Customer;
import com.vlasnakonechnyi.testproject.testproject.entity.CustomerDto;

import java.util.List;

public interface CustomerService {
    public void createCustomer(Customer customer);
    List<CustomerDto> getCustomers();
}
