package com.texas.ecommerce.service.impl;

import com.texas.ecommerce.dto.ProductDto;
import com.texas.ecommerce.model.Product;
import com.texas.ecommerce.repo.ProductRepo;
import com.texas.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    @Override
    public Integer save(ProductDto productDto) {
        Product product = new Product();
        product.setProName(productDto.getProName());
        product.setPrice(productDto.getPrice());
        Product savedProduct = productRepo.save(product);
        return savedProduct.getProId();
    }

    @Override
    public ProductDto getById(Integer id) {
        Product product = productRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("Product not found")
        );
        ProductDto productDto = new ProductDto(
                product.getProName(), product.getPrice(), product.getProId(), product.getImageUrl()
        );
        return productDto;
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> productList = productRepo.findAll();
        List<ProductDto> productDtoList = productList.stream()
                .map(product -> {
                    ProductDto productDto = new ProductDto(product.getProName(), product.getPrice(), product.getProId(), product.getImageUrl());
                    return productDto;
                }).collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public void deleteById(Integer id) {
        productRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("Product not found")
        );
        productRepo.deleteById(id);
    }

    @Override
    public Integer updateById(Integer id, ProductDto productDto){
        Product product = productRepo.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        product.setProName(productDto.getProName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        Product savedProduct = productRepo.save(product);
        return savedProduct.getProId();
    }
}
