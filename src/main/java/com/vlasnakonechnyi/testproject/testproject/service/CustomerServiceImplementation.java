package com.vlasnakonechnyi.testproject.testproject.service;

import com.vlasnakonechnyi.testproject.testproject.dao.CustomerDao;
import com.vlasnakonechnyi.testproject.testproject.entity.Customer;
import com.vlasnakonechnyi.testproject.testproject.entity.CustomerDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class CustomerServiceImplementation implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    @Transactional
    public void createCustomer(Customer customer) {

    }

    @Override
    public List<CustomerDto> getCustomers() {
        return customerDao.getCustomers().stream()
                .map(customer -> new CustomerDto(
                        (long)customer.getId(),
                        customer.getFullName(),
                        customer.getEmail(),
                        customer.getPhone()))
                .collect(Collectors.toList());
    }
}
