package com.company.service;

import com.company.dto.CategoryDTO;
import com.company.dto.converter.CategoryDTOConverter;
import com.company.dto.request.CreateCategoryDTORequest;
import com.company.model.Category;
import com.company.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDTOConverter categoryDTOConverter;


    public CategoryDTO createCategory(CreateCategoryDTORequest createCategoryDTORequest) {

        Category category = new Category(createCategoryDTORequest.getName());
        return categoryDTOConverter.convert(categoryRepository.save(category));
    }

    public List<CategoryDTO> findAll() {
        return categoryDTOConverter.convert(categoryRepository.findAll());
    }

    public CategoryDTO findByName(String name) {
        return categoryDTOConverter.convert(categoryRepository.findByName(name));
    }

    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
