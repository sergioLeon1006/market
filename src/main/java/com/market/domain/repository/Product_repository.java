package com.market.domain.repository;

import com.market.domain.Product_map;

import java.util.List;
import java.util.Optional;

public interface Product_repository {
    List<Product_map> getAll();
    Optional<List<Product_map>> getByCategory(int categoryID);
    Optional<List<Product_map>> getScarseProducts(int quantity);
    Optional<List<Product_map>> getProduct(int productID);
    Product_map save (Product_map productMapp);
    void delete (int productID);
}
