package com.example.demo.requestModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoughtProductsRequestModel {
    private Integer product_quantity;
    private Integer product_amount;
    private Long product_id;
}
