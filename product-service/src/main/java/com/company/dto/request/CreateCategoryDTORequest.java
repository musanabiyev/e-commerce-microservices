package com.company.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryDTORequest {

    private Integer id;

    @NotNull
    @Min(value = 3, message = "name must be at least 3 characters")
    private String name;

}
