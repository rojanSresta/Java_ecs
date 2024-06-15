package com.texas.ecommerce.dto;

public class ProductDto {
    private String proName;
    private Float price;
    private Integer proId;
    private String imageUrl;

    public ProductDto(String proName, Float price, Integer proId) {
        this.proName = proName;
        this.price = price;
        this.proId = proId;
    }

    public ProductDto(String proName, Float price, String imageUrl) {
        this.proName = proName;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public ProductDto(Float price, Integer proId, String imageUrl) {
        this.price = price;
        this.proId = proId;
        this.imageUrl = imageUrl;
    }

    public ProductDto(String proName, Float price, Integer proId, String imageUrl) {
        this.proName = proName;
        this.price = price;
        this.proId = proId;
        this.imageUrl = imageUrl;
    }

    public ProductDto() {
    }

    public ProductDto(String proName, Float price) {
        this.proName = proName;
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }
}
