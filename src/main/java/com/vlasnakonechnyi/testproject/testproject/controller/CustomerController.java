package com.vlasnakonechnyi.testproject.testproject.controller;


import com.vlasnakonechnyi.testproject.testproject.entity.Customer;
import com.vlasnakonechnyi.testproject.testproject.entity.CustomerDto;
import com.vlasnakonechnyi.testproject.testproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerDto> getCustomers() {
        return customerService.getCustomers();
    }
}
