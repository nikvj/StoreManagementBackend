package com.example.demo.service;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.InvoiceHistoryEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.models.Customer;
import com.example.demo.models.InvoiceHistory;
import com.example.demo.requestModels.BoughtProductsRequestModel;

import java.util.List;

public interface InvoiceHistoryServiceInterface {
    Long addInvoiceHistory(Customer customer, List<BoughtProductsRequestModel> boughtProductsRequestModelList, Long invoice_id, Integer total_amount);

    CustomerEntity addCustomerToHistory(Customer customer);
    Boolean addBoughtProductToHistory(List<BoughtProductsRequestModel> productsRequestModelList, Long invoice_id);

    InvoiceHistoryEntity getInvoiceHistoryByInvoiceId(Long invoice_id);
}
