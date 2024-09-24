package com.vlasnakonechnyi.testproject.testproject.service;

import com.vlasnakonechnyi.testproject.testproject.entity.CustomerDto;

import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerDto customerDto);
    List<CustomerDto> getCustomers();
}
