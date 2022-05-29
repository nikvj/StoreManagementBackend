package com.example.demo.controller;

import com.example.demo.models.Customer;
import com.example.demo.requestModels.InvoiceHistoryRequestModel;
import com.example.demo.responseModels.IdResponse;
import com.example.demo.service.InvoiceHistoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/invoiceHistory")
public class InvoiceHistoryController {

    @Autowired
    private InvoiceHistoryServiceInterface invoiceHistoryServiceInterface;

    public InvoiceHistoryController(InvoiceHistoryServiceInterface invoiceHistoryServiceInterface) {
        this.invoiceHistoryServiceInterface = invoiceHistoryServiceInterface;
    }

    @PostMapping(path = "/add")
    public IdResponse addInvoiceHistory(@RequestBody InvoiceHistoryRequestModel invoiceHistory) {
        try {
            Customer customer = invoiceHistory.getCustomer();
            Long invoice_id = invoiceHistory.getInvoice_id();
            Long invoiceId = invoiceHistoryServiceInterface.addInvoiceHistory(customer);
            IdResponse response = new IdResponse();
            response.setId(invoiceId);
            return response;
        }catch (Exception e){
          throw e;
        }
    }
}
