package com.texas.ecommerce.controller;

import com.texas.ecommerce.dto.ProductDto;
import com.texas.ecommerce.dto.UserDto;
import com.texas.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:5173")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity saveProduct(@RequestBody ProductDto productDto){
        Integer data  = productService.save(productDto);
        return ResponseEntity.ok(
                Map.of("message", "Product Added Succesfully", "data", data)
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity findProductById(@PathVariable("id") Integer id){
        ProductDto data = productService.getById(id);
        return ResponseEntity.ok(
                Map.of("message", "Product Data Fetched Successfully", "data", data)
        );
    }

    @GetMapping("/list")
    public ResponseEntity fetchAllProducts(){
        List<ProductDto> data = productService.getAll();
        return ResponseEntity.ok(
                Map.of("message", "All products Fetched Successfully", "data", data)
        );
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteProductById(@PathVariable("id") Integer id){
        productService.deleteById(id);
        return  ResponseEntity.ok(
                Map.of("message", "Product Deleted Successfully")
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProductById(@PathVariable Integer id, @RequestBody ProductDto productDto){
        productService.updateById(id, productDto);
        return ResponseEntity.ok(
                Map.of("message", "Product data updated successfully")
        );
    }
}
