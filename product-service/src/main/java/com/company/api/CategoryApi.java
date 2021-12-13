package com.company.api;


import com.company.dto.CategoryDTO;
import com.company.dto.request.CreateCategoryDTORequest;
import com.company.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/category")
@RequiredArgsConstructor
public class CategoryApi {

    private final CategoryService categoryService;

    @PostMapping("/addcategory")
    public ResponseEntity<CategoryDTO> createCategory(CreateCategoryDTORequest createCategoryDTORequest) {
        return ResponseEntity.ok(categoryService.createCategory(createCategoryDTORequest));
    }

}
