package com.market.persistence.mapper;

import com.market.domain.Product_map;
import com.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses ={Category_mapper.class})//uses when a source has a mapper
public interface Product_mapper {
    @Mappings({
            @Mapping(source = "idProduct",target = "productID"),
            @Mapping(source = "name",target = "productName"),
            @Mapping(source = "idCategory",target = "categoryID"),
            @Mapping(source = "price",target = "price"),
            @Mapping(source = "amount",target = "stock"),
            @Mapping(source = "status",target = "status"),
            @Mapping(source = "category",target = "category_map"),
    })
    Product_map toProduct(Product product);
    List<Product> toProduct(List<Product> product);

    @InheritInverseConfiguration
    @Mapping(target = "code",ignore = true)
    Product toProduct_map(Product_map category_map);

}
