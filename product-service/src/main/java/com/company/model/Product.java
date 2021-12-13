package com.company.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * @author M
 */
@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "color")
    private String color;

    @Column(name = "description")
    private String description;

    @Column(name = "dimensions")
    private String dimensions;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "is_active")
    private Boolean isActive;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private Category categoryId;

    @OneToMany(mappedBy = "productId")
    private List<ProductImage> productImageList;

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public Product(Long id, List<ProductImage> productImageList) {
        this.id = id;
        this.productImageList = productImageList;
    }

    public Product(Long id, String name, String code, String color, String description,
                   String dimensions, BigDecimal price, Category category) {

        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.color = color;
        this.dimensions = dimensions;
        this.price = price;
        this.categoryId = category;

    }

    public Product(String name, String code, String description, String color,
                   String dimensions, BigDecimal price, Category categoryId) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.color = color;
        this.dimensions = dimensions;
        this.price = price;
        this.categoryId = categoryId;
    }
}
