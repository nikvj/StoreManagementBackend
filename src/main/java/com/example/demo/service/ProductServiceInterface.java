package com.example.demo.service;

import com.example.demo.models.Products;
import com.example.demo.requestModels.DeleteRequestModel;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {
    Products saveProduct(Products product);

    List<Products> fetchProductsList();

    Products updateProduct(Products product, Long productId);

    void deleteProductById(Long productId);

//    List<Products> updateProductStatus(List<Products> products);

    void deleteSelectedProductById(DeleteRequestModel ids);

    Products searchProductByCode(Optional<String> productCode);
}
