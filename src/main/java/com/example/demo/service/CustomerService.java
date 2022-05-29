package com.example.demo.service;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerServiceInterface{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Long addCustomer(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
        customerRepository.save(customerEntity);
        return customerEntity.getId();
    }
}
