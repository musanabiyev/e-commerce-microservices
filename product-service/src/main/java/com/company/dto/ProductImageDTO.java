package com.company.dto;

import lombok.Data;

@Data
public class ProductImageDTO {

    private Long id;
    private String imageUrl;
    private Long productId;

    public ProductImageDTO() {
    }

    public ProductImageDTO(String imageUrl, Long productId) {
        this.imageUrl = imageUrl;
        this.productId = productId;
    }

    public ProductImageDTO(Long id, String imageUrl, Long productId) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.productId = productId;
    }
}
