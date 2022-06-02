package com.example.demo.service;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerServiceInterface{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public CustomerEntity addCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity getCustomerByContact(Long contact) {
        CustomerEntity searchedByContact = customerRepository.customerByContact(contact);
        if (searchedByContact != null){
            return searchedByContact;
        }
        return null;
    }

    @Override
    public CustomerEntity getCustomerById(Long customerId) {
        return customerRepository.getById(customerId);
    }
}
