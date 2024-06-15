package com.texas.ecommerce.service;

import com.texas.ecommerce.dto.ProductDto;
import com.texas.ecommerce.dto.UserDto;

import java.util.List;

public interface ProductService {

    Integer save(ProductDto productDto);
    ProductDto getById(Integer id);
    List<ProductDto> getAll();
    void deleteById(Integer id);

    Integer updateById(Integer id, ProductDto productDto);
}
