package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(unique = true)
    private String code;
    private String product_name;
    private String status;
    private Integer quantity;
    private String quantity_unit;
    private Integer price;
    private String price_unit;
}
