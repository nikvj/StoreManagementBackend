package com.example.demo.controller;

import com.example.demo.entity.BoughtProductHistory;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.InvoiceHistoryEntity;
import com.example.demo.models.Customer;
import com.example.demo.requestModels.BoughtProductsRequestModel;
import com.example.demo.requestModels.InvoiceHistoryRequestModel;
import com.example.demo.responseModels.IdResponse;
import com.example.demo.responseModels.InvoiceHistoryResponseModel;
import com.example.demo.service.BoughtProductHistoryServiceInterface;
import com.example.demo.service.InvoiceHistoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/invoiceHistory")
@CrossOrigin("*")
public class InvoiceHistoryController {

    @Autowired
    private InvoiceHistoryServiceInterface invoiceHistoryServiceInterface;

    @Autowired
    private BoughtProductHistoryServiceInterface boughtProductHistoryServiceInterface;

    public InvoiceHistoryController(InvoiceHistoryServiceInterface invoiceHistoryServiceInterface, BoughtProductHistoryServiceInterface boughtProductHistoryServiceInterface) {
        this.invoiceHistoryServiceInterface = invoiceHistoryServiceInterface;
        this.boughtProductHistoryServiceInterface = boughtProductHistoryServiceInterface;
    }

    @GetMapping("/all")
    public List<InvoiceHistoryResponseModel> getInvoices(){
        List<InvoiceHistoryEntity> invoiceHistory = invoiceHistoryServiceInterface.getInvoiceHistory();
        List<InvoiceHistoryResponseModel> response = new ArrayList<>();
        for (InvoiceHistoryEntity history: invoiceHistory) {
            Long invoice_id = history.getInvoice_id();
            List<BoughtProductHistory> boughtProductHistory = boughtProductHistoryServiceInterface.getHistoryByInvoiceId(invoice_id);
            CustomerEntity customer = history.getCustomer();
            Integer total_amount = history.getTotal_amount();
            InvoiceHistoryResponseModel responseModel = new InvoiceHistoryResponseModel();
            responseModel.setId(history.getId());
            responseModel.setInvoice_id(invoice_id);
            responseModel.setTotal_amount(total_amount);
            responseModel.setProducts(boughtProductHistory);
            responseModel.setCustomer(customer);
            response.add(responseModel);
        }
        return response;
    }

    @PostMapping(path = "/add")
    public IdResponse addInvoiceHistory(@RequestBody InvoiceHistoryRequestModel invoiceHistory) {
        try {
            List<BoughtProductsRequestModel> boughtProductsRequestModelList = invoiceHistory.getProducts();
            Customer customer = invoiceHistory.getCustomer();
            Long invoice_id = invoiceHistory.getInvoice_id();
            Integer total_amount = invoiceHistory.getTotal_amount();
            Long invoiceId = invoiceHistoryServiceInterface.addInvoiceHistory(customer, boughtProductsRequestModelList,
                    invoice_id, total_amount);
            IdResponse response = new IdResponse();
            response.setId(invoiceId);
            return response;
        }catch (Exception e){
          throw e;
        }
    }

    @GetMapping("/invoiceHistoryById/{invoice_id}")
    public InvoiceHistoryResponseModel getInvoiceById(@PathVariable("invoice_id") Long invoice_id){
        InvoiceHistoryResponseModel response = new InvoiceHistoryResponseModel();
        InvoiceHistoryEntity invoiceHistory = invoiceHistoryServiceInterface.getInvoiceHistoryByInvoiceId(invoice_id);
        List<BoughtProductHistory> boughtProductHistory = boughtProductHistoryServiceInterface.getHistoryByInvoiceId(invoice_id);
        response.setId(invoiceHistory.getId());
        response.setInvoice_id(invoice_id);
        response.setTotal_amount(invoiceHistory.getTotal_amount());
        response.setCustomer(invoiceHistory.getCustomer());
        response.setProducts(boughtProductHistory);
        return response;
    }

}
