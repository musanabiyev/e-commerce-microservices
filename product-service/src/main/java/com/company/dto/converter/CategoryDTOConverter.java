package com.company.dto.converter;

import com.company.dto.CategoryDTO;
import com.company.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDTOConverter {

    public CategoryDTO convert(Category from) {
        return new CategoryDTO(from.getId(), from.getName());
    }

    public List<CategoryDTO> convert(List<Category> fromList) {
        return fromList.stream().map(this::convert).collect(Collectors.toList());
    }


}
