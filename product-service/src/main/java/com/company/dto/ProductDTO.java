package com.company.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String code;
    private String description;
    private String color;
    private String dimensions;
    private BigDecimal price;
    private CategoryDTO categoryId;
    private List<ProductImageDTO> productImageList;


    public ProductDTO(
            Long id, String name, String code, String description,
            String color, String dimensions, BigDecimal price, CategoryDTO categoryId) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.color = color;
        this.dimensions = dimensions;
        this.price = price;
        this.categoryId = categoryId;
    }

    public ProductDTO(
            Long id, String name, String code, String description,
            String color, String dimensions, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.color = color;
        this.dimensions = dimensions;
        this.price = price;
    }
}
