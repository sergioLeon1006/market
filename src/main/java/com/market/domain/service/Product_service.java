package com.market.domain.service;

import com.market.domain.Product_map;
import com.market.domain.repository.Product_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class Product_service {
    @Autowired
    private Product_repository  pr;

    public List<Product_map> getAll() {
        return pr.getAll();
    }

    public Optional<List<Product_map>> getByCategory(int id) {
        return pr.getByCategory(id);
    }

    public Optional<List<Product_map>> getScarceProducts(int quantity){
        return pr.getScarseProducts(quantity);
    }

    public Optional<Product_map> getProduct(int id){
        return pr.getProduct(id);
    }

    public Product_map save (Product_map product){
        return pr.save(product);
    }

    public boolean delete (int id){
        return pr.getProduct(id).map(product ->{
           pr.delete(id);
           return true;
        }).orElse(false);
    }
}
