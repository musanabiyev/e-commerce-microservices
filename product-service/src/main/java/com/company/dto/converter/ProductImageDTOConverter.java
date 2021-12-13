package com.company.dto.converter;

import com.company.dto.ProductImageDTO;
import com.company.model.ProductImage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductImageDTOConverter {

    public ProductImageDTO convert(ProductImage from) {
        return new ProductImageDTO(from.getId(), from.getImageUrl(), from.getId());
    }

    public List<ProductImageDTO> convert(List<ProductImage> fromList) {
        return fromList.stream().map(this::convert).collect(Collectors.toList());
    }
}
