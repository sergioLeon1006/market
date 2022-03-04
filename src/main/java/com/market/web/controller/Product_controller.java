package com.market.web.controller;

import com.market.domain.Product_map;
import com.market.domain.service.Product_service;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class Product_controller {

    @Autowired
    private Product_service ps;

    @GetMapping("getAll")
    @ApiOperation("get all super markets products")
    @ApiResponse(code = 200, message = "success")
    public ResponseEntity<List<Product_map>>getAll() {
        return new ResponseEntity<>(ps.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    @ApiOperation("search a product by id")
    @ApiResponses({
            @ApiResponse(code =200, message = "success"),
            @ApiResponse(code = 404, message = "product not found")
    })
    public ResponseEntity<Product_map> getProduct(@ApiParam(value = "product id", required = true,example = "7") @PathVariable("productId") int id){
        return ps.getProduct(id)
                .map(product->new ResponseEntity<>(product, HttpStatus.OK)).
                    orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product_map>> getByCategory(@PathVariable("categoryId") int id) {
        return ps.getByCategory(id)
                .map(products->new ResponseEntity<>(products, HttpStatus.OK)).
                    orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/Scarce/{quantity}")
    public ResponseEntity<List<Product_map>> getScarceProducts(@PathVariable("quantity") int quantity){
        return ps.getScarceProducts(quantity)
                .map(products->new ResponseEntity<>(products,HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product_map> save (@RequestBody Product_map product){
        return new ResponseEntity<>(ps.save(product),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product_map>  update (@RequestBody Product_map product){
        return new ResponseEntity<>(ps.save(product),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        if (ps.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
