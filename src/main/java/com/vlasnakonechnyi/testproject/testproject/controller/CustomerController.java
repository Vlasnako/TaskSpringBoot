package com.vlasnakonechnyi.testproject.testproject.controller;


import com.vlasnakonechnyi.testproject.testproject.entity.Customer;
import com.vlasnakonechnyi.testproject.testproject.entity.CustomerDto;
import com.vlasnakonechnyi.testproject.testproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/{id}")
//    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
//        CustomerDto customerDto = customerService.getCustomerById(id);
//        return customerDto != null ? ResponseEntity.ok(customerDto) : ResponseEntity.notFound().build();
//    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.createCustomer(customerDto);
        return ResponseEntity.ok(createdCustomer);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<CustomerDto> updateCustomer(
//            @PathVariable Long id,
//            @RequestBody CustomerDto customerDto) {
//        CustomerDto updatedCustomer = customerService.updateCustomer(id, customerDto);
//        return updatedCustomer != null ? ResponseEntity.ok(updatedCustomer) : ResponseEntity.notFound().build();
//    }
}
