package com.example.demo.service;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.InvoiceHistoryEntity;
import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.InvoiceHistoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceHistoryService implements InvoiceHistoryServiceInterface{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerServiceInterface customerServiceInterface;

    @Autowired
    InvoiceHistoryRepository invoiceHistoryRepository;

    @Override
    public Long addInvoiceHistory(Customer customerData) {
        InvoiceHistoryEntity invoiceHistory = new InvoiceHistoryEntity();
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customerData, customerEntity);
            Long customerId;
            Long contact = customerData.getContact();
            CustomerEntity customer = customerRepository.customerByContact(Optional.ofNullable(contact));
            if (customer == null){
               customerId = customerServiceInterface.addCustomer(customerData);
               if (customerId != null){
                   invoiceHistory.setCustomer(customerRepository.getById(customerId));
               }
            }
            invoiceHistoryRepository.save(invoiceHistory);
            Long invoiceId = invoiceHistory.getId();
            return invoiceId;
    }
}
