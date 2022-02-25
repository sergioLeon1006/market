package com.market.persistence.mapper;

import com.market.domain.Category_map;
import com.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface Category_mapper {
    @Mappings({
            @Mapping(source = "idCategory",target = "categoryID"),
            @Mapping(source = "description",target = "category"),
            @Mapping(source = "state",target = "status"),
    })
    Category_map toCategory(Category category); //convert Category to Category(entity)

    @InheritInverseConfiguration
    @Mapping(target = "idCategory",ignore = true)
    Category toCategory_map(Category_map category_map);
}
