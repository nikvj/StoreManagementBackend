package com.example.demo.models;

import com.example.demo.requestModels.BuyingProducts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceHistory {
    private Long id;
    private Long invoice_id;
    private Integer total_amount;
    private Customer customer;
    private List<BuyingProducts> products;
}
