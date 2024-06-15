package com.texas.ecommerce.service.impl;

import com.texas.ecommerce.dto.OrderDto;
import com.texas.ecommerce.model.Order;
import com.texas.ecommerce.model.Product;
import com.texas.ecommerce.model.User;
import com.texas.ecommerce.repo.OrderRepo;
import com.texas.ecommerce.repo.ProductRepo;
import com.texas.ecommerce.repo.UserRepo;
import com.texas.ecommerce.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;
    private final UserRepo userRepo;

    public OrderServiceImpl(OrderRepo orderRepo, ProductRepo productRepo, UserRepo userRepo){
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.userRepo = userRepo;
    }
    @Override
    public Integer save(OrderDto orderDto) {
        Order order = new Order();
        Product product = productRepo.findById(orderDto.getProduct_id()).orElseThrow(() -> new RuntimeException("Product not found"));
        order.setProduct(product);
        User user = userRepo.findById(orderDto.getUser_id()).orElseThrow(() -> new RuntimeException("User not found"));
        order.setUser(user);
        order.setQuantity(orderDto.getQuantity());
        order.setDate(orderDto.getDate());
        Order savedOrder = orderRepo.save(order);
        return savedOrder.getId();
    }
}
