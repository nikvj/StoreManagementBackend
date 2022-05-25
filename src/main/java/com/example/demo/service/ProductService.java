package com.example.demo.service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.models.Products;
import com.example.demo.repository.ProductRepository;
import com.example.demo.requestModels.DeleteRequestModel;
import com.example.demo.utility.StatusEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Products saveProduct(Products product) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        if (productEntity.getQuantity() > 5){
            productEntity.setStatus(StatusEnum.INSTOCK.toString());
        } else if (productEntity.getQuantity() >= 1 && productEntity.getQuantity() <= 5) {
            productEntity.setStatus(StatusEnum.RUNNINGOUTOFSTOCK.toString());
        }else {
            productEntity.setStatus(StatusEnum.OUTOFSTOCK.toString());
        }
        Random random = new Random();
        String product_code = "AKS"+random.nextInt(1000);
        productEntity.setCode(product_code);
        productRepository.save(productEntity);
        return product;
    }

    @Override
    public List<Products> fetchProductsList() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<Products> productsList = productEntities.stream().map(productEntity -> new Products(
                productEntity.getId(), productEntity.getCode(), productEntity.getProduct_name(), productEntity.getStatus(), productEntity.getQuantity(),
                productEntity.getQuantity_unit(), productEntity.getPrice(),
                productEntity.getPrice_unit())).collect(Collectors.toList());
        return productsList;
    }

    @Override
    public Products updateProduct(Products product, Long productId) {
        ProductEntity productDB
                = productRepository.findById(productId)
                .get();

        if (Objects.nonNull(product.getProduct_name())
                && !"".equalsIgnoreCase(
                product.getProduct_name())) {
            productDB.setProduct_name(
                    product.getProduct_name());
        }

        if (Objects.nonNull(product.getPrice())
                && !"".equalsIgnoreCase(
                product.getPrice().toString())) {
            productDB.setPrice(
                    product.getPrice());
        }

        if (Objects.nonNull(product.getQuantity())
                && !"".equalsIgnoreCase(
                product.getQuantity().toString())) {
            productDB.setQuantity(
                    product.getQuantity());
            if (product.getQuantity() > 5){
                productDB.setStatus(StatusEnum.INSTOCK.toString());
            } else if (product.getQuantity() >= 1 && product.getQuantity() <= 5) {
                productDB.setStatus(StatusEnum.RUNNINGOUTOFSTOCK.toString());
            }else {
                productDB.setStatus(StatusEnum.OUTOFSTOCK.toString());
            }
        }

        productRepository.save(productDB);
        return product;
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public void deleteSelectedProductById(DeleteRequestModel ids) {
        for (Long id: ids.getIds()) {
            productRepository.deleteById(id);
        }
    }

   /* @Override
    public List<Products> updateProductStatus(List<Products> productsList) {
        List<Products> products = new ArrayList<>();
        for (Products p:
                productsList) {
            if (p.getQuantity() > 5){
                p.setStatus(StatusEnum.INSTOCK.toString());
                products.add(p);
            } else if (p.getQuantity() >= 1 && p.getQuantity() <= 5) {
                p.setStatus(StatusEnum.RUNNINGOUTOFSTOCK.toString());
                products.add(p);
            }else {
                p.setStatus(StatusEnum.OUTOFSTOCK.toString());
                products.add(p);
            }
        }
        return products;
    }*/
}
