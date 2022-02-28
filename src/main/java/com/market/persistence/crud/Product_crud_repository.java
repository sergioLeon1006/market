package com.market.persistence.crud;

import com.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface Product_crud_repository extends CrudRepository<Product,Integer> {
    List<Product> findByIdCategoryOrderByNameAsc(int idCategory);
    Optional<List<Product>> findByAmountLessThanAndStatus(int amount, boolean status);
}
