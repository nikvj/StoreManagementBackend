package com.example.demo.controller;

import com.example.demo.models.Products;
import com.example.demo.requestModels.DeleteRequestModel;
import com.example.demo.responseModels.ProductResponse;
import com.example.demo.service.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductServiceInterface productServiceInterface;

    @PostMapping("/add")
    public Products saveProduct(
            @RequestBody Products products) {
        return productServiceInterface.saveProduct(products);
    }

    @GetMapping("/all")
    public ProductResponse fetchProductList() {
        ProductResponse response = new ProductResponse();
        List<Products> productsList = productServiceInterface.fetchProductsList();
        response.setProducts(productsList);
        return response;
    }

    @PutMapping("/update/{id}")
    public Products
    updateProduct(@RequestBody Products product,
               @PathVariable("id") Long productId) {
        return productServiceInterface.updateProduct(
                product, productId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProductById(@PathVariable("id")
                                 Long productId) {
        productServiceInterface.deleteProductById(
                productId);
        return "Deleted Successfully";
    }

    @PostMapping("/delete/all")
    public String deleteSelectedProductByIds(@RequestBody DeleteRequestModel ids) {
        productServiceInterface.deleteSelectedProductById(ids);
        return "Deleted Successfully";
    }
}
