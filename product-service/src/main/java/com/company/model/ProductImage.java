package com.company.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author M
 */

@Data
@Entity
@Table(name = "product_image")
public class ProductImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Product productId;

    public ProductImage() {
    }


    public ProductImage(Long id) {
        this.id = id;
    }

    public ProductImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductImage(String imageUrl, Product productId) {
        this.imageUrl = imageUrl;
        this.productId = productId;
    }

    public ProductImage(Long id, String imageUrl, Product productId) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.productId = productId;
    }
}
