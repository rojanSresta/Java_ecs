package com.texas.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @SequenceGenerator(name = "product_id", sequenceName = "product_id", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id")
    private Integer proId;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "proName", nullable = false)
    private String proName;

    @Column(name = "imageUrl", nullable = false)
    private String imageUrl;

    public Product() {
    }

    public Product(Integer proId, Float price, String proName, String imageUrl) {
        this.proId = proId;
        this.price = price;
        this.proName = proName;
        this.imageUrl = imageUrl;
    }


    public Product(Float price, String proName, String imageUrl) {
        this.price = price;
        this.proName = proName;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Product(Float price, String proName) {
        this.price = price;
        this.proName = proName;
    }

    public Product(Integer proId, Float price, String proName) {
        this.proId = proId;
        this.price = price;
        this.proName = proName;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
}
