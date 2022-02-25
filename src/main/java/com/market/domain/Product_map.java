package com.market.domain;

import lombok.Data;

@Data
public class Product_map {
    private int productID;
    private String productName;
    private int categoryID;
    private double price;
    private int stock;
    private boolean status;
    private Category_map category_map;

}
