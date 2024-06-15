package com.texas.ecommerce.dto;

import java.time.LocalDate;

public class OrderDto {
    private Integer id;
    private Integer user_id;
    private Integer product_id;
    private Integer quantity;

    private String user_name;
    private String product_name;
    private Float price;

    private LocalDate date;

    public LocalDate getDate() {
        return LocalDate.now();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public OrderDto(Integer user_id, Integer product_id, Integer quantity, String user_name, String product_name, Float price, LocalDate date) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.user_name = user_name;
        this.product_name = product_name;
        this.price = price;
        this.date = date;
    }

    public OrderDto(Integer id, Integer user_id, Integer product_id, Integer quantity, String user_name, String product_name, Float price, LocalDate date) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.user_name = user_name;
        this.product_name = product_name;
        this.price = price;
        this.date = date;
    }

    public OrderDto(Integer id, String user_name, String product_name, Float price, Integer quantity) {
        this.id = id;
        this.user_name = user_name;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDto(String user_name, String product_name, Float price, Integer quantity) {
        this.user_name = user_name;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDto(Integer user_id, Integer product_id, Integer quantity) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public OrderDto(Integer id, Integer user_id, Integer product_id, Integer quantity) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public OrderDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", user_name='" + user_name + '\'' +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                '}';
    }
}
