package com.example.demo.models;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Products {
    private Long Id;
    private String code;
    private String product_name;
    private String status;
    private Integer quantity;
    private String quantity_unit;
    private Integer price;
    private String price_unit;
}
