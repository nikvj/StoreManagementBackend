package com.example.demo.requestModels;

import com.example.demo.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceHistoryRequestModel {
    private Long id;
    private Long invoice_id;
    private Integer total_amount;
    private Customer customer;
    private List<BoughtProductsRequestModel> products;
}
