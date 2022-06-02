package com.example.demo.service;

import com.example.demo.entity.CustomerEntity;

public interface CustomerServiceInterface {

    CustomerEntity addCustomer(CustomerEntity customer);

    CustomerEntity getCustomerByContact(Long contact);

    CustomerEntity getCustomerById(Long customerId);
}
