package com.example.demo.service;

import com.example.demo.entity.BoughtProductHistory;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.InvoiceHistoryEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.models.Customer;
import com.example.demo.repository.InvoiceHistoryRepository;
import com.example.demo.requestModels.BoughtProductsRequestModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceHistoryService implements InvoiceHistoryServiceInterface{

    @Autowired
    CustomerServiceInterface customerServiceInterface;

    @Autowired
    InvoiceHistoryRepository invoiceHistoryRepository;

    @Autowired
    ProductServiceInterface productServiceInterface;

    @Autowired
    BoughtProductHistoryServiceInterface boughtProductHistoryServiceInterface;

    @Override
    public Long addInvoiceHistory(Customer customer, List<BoughtProductsRequestModel> boughtProductsRequestModelList,
                                  Long invoice_id, Integer total_amount) {
        Long invoiceId = null;
        try {
            InvoiceHistoryEntity invoiceHistory = new InvoiceHistoryEntity();
            CustomerEntity customerEntity = addCustomerToHistory(customer);
            Boolean isProductHistorySaved = addBoughtProductToHistory(boughtProductsRequestModelList, invoice_id);
            if (isProductHistorySaved){
                invoiceHistory.setCustomer(customerEntity);
                invoiceHistory.setInvoice_id(invoice_id);
                invoiceHistory.setTotal_amount(total_amount);
                invoiceHistoryRepository.save(invoiceHistory);
                invoiceId = invoiceHistory.getId();
            }
            return invoiceId;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public CustomerEntity addCustomerToHistory(Customer customer) {
        try {
            CustomerEntity customerEntity = new CustomerEntity();
            BeanUtils.copyProperties(customer, customerEntity);
            Long customerId;
            Long contact = customer.getContact();
            CustomerEntity customerById;
            CustomerEntity searchedByContact = customerServiceInterface.getCustomerByContact(contact);
            if (searchedByContact == null) {
                customerById = customerServiceInterface.addCustomer(customerEntity);
                return customerById;
            }else {
                customerId = searchedByContact.getId();
                if (customerId != null ){
                    customerById = customerServiceInterface.getCustomerById(customerId);
                    return customerById;
                }
            }
        }catch (Exception e){
            throw e;
        }
        return null;
    }

    @Override
    public Boolean addBoughtProductToHistory(List<BoughtProductsRequestModel> productsRequestModelList, Long invoice_id) {
        try {
            BoughtProductHistory boughtProductHistory = new BoughtProductHistory();
            for (BoughtProductsRequestModel boughtProductsRequestModel:
                    productsRequestModelList) {
                ProductEntity product = productServiceInterface.getProductById(boughtProductsRequestModel.getProduct_id());
                boughtProductHistory.setProduct(product);
                boughtProductHistory.setInvoice_id(invoice_id);
                boughtProductHistory.setProduct_amount(boughtProductsRequestModel.getProduct_amount());
                boughtProductHistory.setProduct_quantity(boughtProductsRequestModel.getProduct_quantity());
                boughtProductHistoryServiceInterface.addBoughtHistory(boughtProductHistory);
                return true;
            }
        }catch (Exception e){
            throw e;
        }
        return false;
    }

    @Override
    public InvoiceHistoryEntity getInvoiceHistoryByInvoiceId(Long invoice_id) {
        return invoiceHistoryRepository.invoiceById(invoice_id);
    }
}
