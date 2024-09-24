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
    public void createCustomer(CustomerDto customerDto) {
        customerDao.createCustomer(mapToEntity(customerDto));
    }

    @Override
    public List<CustomerDto> getCustomers() {
        return customerDao.getCustomers().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private CustomerDto mapToDto(Customer customer) {
        return new CustomerDto((long)customer.getId(), customer.getFullName(), customer.getEmail(), customer.getPhone());
    }

    private Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFullName(customerDto.getFullName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        return customer;
    }
}
