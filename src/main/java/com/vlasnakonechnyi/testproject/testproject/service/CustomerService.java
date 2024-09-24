package com.vlasnakonechnyi.testproject.testproject.service;

import com.vlasnakonechnyi.testproject.testproject.entity.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    List<CustomerDto> getCustomers();

    CustomerDto getCustomerById(long id);

    CustomerDto updateCustomer(Long id, CustomerDto customerDto);

    void deleteCustomer(Long id);
}
