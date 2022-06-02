package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bought_product_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoughtProductHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long invoice_id;
    private Integer product_quantity;
    private Integer product_amount;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}
