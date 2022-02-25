package com.market.persistence.crud;

import com.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface Product_crud_repository extends CrudRepository<Product,Integer> {

}
