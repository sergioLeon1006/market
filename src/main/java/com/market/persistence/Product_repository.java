package com.market.persistence;

import com.market.domain.Product_map;
import com.market.persistence.crud.Product_crud_repository;
import com.market.persistence.entity.Product;
import com.market.persistence.mapper.Product_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class Product_repository implements com.market.domain.repository.Product_repository {
   @Autowired //dependency inyections, only spring components
   private Product_crud_repository pcr;
   @Autowired
   private Product_mapper mapper;

   @Override
   public List<Product_map> getAll() {
      List<Product> products = (List<Product>) pcr.findAll();
      return mapper.toProducts_map(products);
   }

   @Override
   public Optional<List<Product_map>> getByCategory (int idCategory) {
      List<Product> products = pcr.findByIdCategoryOrderByNameAsc(idCategory);
       return Optional.of(mapper.toProducts_map(products));
   }

   @Override
   public Optional<List<Product_map>> getScarseProducts (int quantity){
      Optional<List<Product>> products = pcr.findByAmountLessThanAndStatus(quantity,true);
      return products.map(p->mapper.toProducts_map(p));
   }

   @Override
   public Optional<Product_map> getProduct(int productID) {
      return pcr.findById(productID).map(p -> mapper.toProduct_map(p));
   }

   @Override
   public Product_map save(Product_map productMapp) {
      Product product = mapper.toProduct_entity(productMapp);
      return mapper.toProduct_map(pcr.save(product));
   }

   @Override
   public void delete(int productID) {

   }
}
