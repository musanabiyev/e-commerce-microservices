package com.company.service;

import com.company.dto.ProductDTO;
import com.company.dto.converter.ProductDTOConverter;
import com.company.dto.request.CreateProductDTORequest;
import com.company.dto.request.UpdateProductDTORequest;
import com.company.exception.ProductNotFoundException;
import com.company.model.Category;
import com.company.model.Product;
import com.company.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDTOConverter productDTOConverter;

    public ProductDTO createProduct(CreateProductDTORequest createProductDTORequest) {

        Category category = new Category(createProductDTORequest.getCategoryId());

        Product product = new Product(
                createProductDTORequest.getName(),
                createProductDTORequest.getCode(),
                createProductDTORequest.getColor(),
                createProductDTORequest.getDescription(),
                createProductDTORequest.getDimensions(),
                createProductDTORequest.getPrice(),
                category);


        return productDTOConverter.convert(productRepository.save(product));
    }


    public ProductDTO updateProduct(UpdateProductDTORequest updateProductDTORequest) {

        Product productById = findProductById(updateProductDTORequest.getId());

        Category category = new Category(
                updateProductDTORequest.getCategoryId());

        Product product = new Product(
                productById.getId(),
                updateProductDTORequest.getName(),
                updateProductDTORequest.getCode(),
                updateProductDTORequest.getColor(),
                updateProductDTORequest.getDescription(),
                updateProductDTORequest.getDimensions(),
                updateProductDTORequest.getPrice(),
                category);

        return productDTOConverter.convert(productRepository.save(product));
    }


    public List<ProductDTO> getAllProduct() {
        return productDTOConverter.convert(productRepository.findAll());
    }

    public void deleteProduct(Long id) {
        productRepository.delete(findProductById(id));
    }

    protected Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(
                        () -> new ProductNotFoundException("product with id " + id + " could not found"));
    }

}
