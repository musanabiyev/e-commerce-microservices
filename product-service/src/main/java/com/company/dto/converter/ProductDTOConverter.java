package com.company.dto.converter;

import com.company.dto.ProductDTO;
import com.company.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductDTOConverter {

    private final ProductImageDTOConverter productImageDTOConverter;
    private final CategoryDTOConverter categoryDTOConverter;


    public ProductDTO convert(Product from) {
        return new ProductDTO(
                from.getId(),
                from.getName(),
                from.getCode(),
                from.getColor(),
                from.getDescription(),
                from.getDimensions(),
                from.getPrice(),
                categoryDTOConverter.convert(from.getCategoryId()),
                productImageDTOConverter.convert(from.getProductImageList()));
    }

    public List<ProductDTO> convert(List<Product> fromList) {
        return fromList.stream().map(from -> new ProductDTO(
                from.getId(),
                from.getName(),
                from.getCode(),
                from.getColor(),
                from.getDescription(),
                from.getDimensions(),
                from.getPrice()
        )).collect(Collectors.toList());
    }

}