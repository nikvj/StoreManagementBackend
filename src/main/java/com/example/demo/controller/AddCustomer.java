package com.example.demo.controller;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.models.Customer;
import com.example.demo.responseModels.IdResponse;
import com.example.demo.service.CustomerServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/")
public class AddCustomer {
    @Autowired
    CustomerServiceInterface customerServiceInterface;

    @PostMapping("/add")
    public IdResponse addCustomer(@RequestBody Customer customer){
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
        customerEntity = customerServiceInterface.addCustomer(customerEntity);
        Long customerId = customerEntity.getId();
        IdResponse response = new IdResponse();
        response.setId(customerId);
        return response;
    }
}
