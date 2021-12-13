package com.company.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDTORequest {

    @NotNull
    @Min(value = 3, message = "name must be at least 3 characters")
    private String name;

    private String code;

    private String description;

    private String color;

    private String dimensions;

    private BigDecimal price;

    @NotNull
    private Integer categoryId;
}
