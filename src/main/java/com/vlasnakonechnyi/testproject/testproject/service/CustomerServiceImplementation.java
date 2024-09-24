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
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerDao.createCustomer(mapToEntity(customerDto));
        if (customer == null) {
            return null;
        } else return mapToDto(customer);
    }

    @Override
    public List<CustomerDto> getCustomers() {
        return customerDao.getCustomers().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        if (customerDao.getCustomerById(id) == null) {
            return null;
        } else {
            return mapToDto(customerDao.getCustomerById(id));
        }
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer existingCustomer = customerDao.getCustomerById(id);

        if (existingCustomer != null) {
            existingCustomer.setFullName(customerDto.getFullName());
            existingCustomer.setPhone(customerDto.getPhone());
            Customer customer = customerDao.updateCustomer(existingCustomer);
            return mapToDto(customer);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer existingCustomer = customerDao.getCustomerById(id);
        if (existingCustomer != null) {
            existingCustomer.setActive(false);
            customerDao.updateCustomer(existingCustomer);
        }
    }

    private CustomerDto mapToDto(Customer customer) {
        return new CustomerDto((long) customer.getId(), customer.getFullName(), customer.getEmail(), customer.getPhone());
    }

    private Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFullName(customerDto.getFullName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        return customer;
    }
}
