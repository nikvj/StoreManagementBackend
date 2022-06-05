package com.example.demo.responseModels;

import com.example.demo.entity.BoughtProductHistory;
import com.example.demo.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceHistoryResponseModel {
    private Long id;
    private Long invoice_id;
    private Integer total_amount;
    private CustomerEntity customer;
    private List<BoughtProductHistory> products;
}
