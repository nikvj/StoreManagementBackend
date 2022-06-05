package com.example.demo.models;

import com.example.demo.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoughtProductHistory {
    private Long id;
    private Long invoice_id;
    private Integer product_quantity;
    private Integer product_amount;
    private ProductEntity product;
}
