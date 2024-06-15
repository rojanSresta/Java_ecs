package com.texas.ecommerce.controller;

import com.texas.ecommerce.dto.OrderDto;
import com.texas.ecommerce.model.Order;
import com.texas.ecommerce.repo.OrderRepo;
import com.texas.ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderRepo orderRepo;

    public OrderController(OrderService orderService, OrderRepo orderRepo){
        this.orderService = orderService;
        this.orderRepo = orderRepo;
    }

    @PostMapping("/save")
    public ResponseEntity placeOrder(@RequestBody OrderDto orderDto){
        Integer data = orderService.save(orderDto);
        return ResponseEntity.ok(
                Map.of("message", "Order Placed Successfully", "data", data)
        );
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getOrderByUserId(@PathVariable Integer id){
        List<Order> orderList =  orderRepo.fetchOrderByUserId(id);
        List<OrderDto> orderListDto = orderList.stream()
                .map(order -> {
                    OrderDto orderDto = new OrderDto();
                    orderDto.setId(order.getId());
                    orderDto.setUser_id(order.getUser().getId());
                    orderDto.setProduct_id(order.getProduct().getProId());
                    orderDto.setUser_name(order.getUser().getName());
                    orderDto.setProduct_name(order.getProduct().getProName());
                    orderDto.setPrice(order.getProduct().getPrice());
                    orderDto.setQuantity(order.getQuantity());
                    return orderDto;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(
                Map.of("message", "Order Fetched Successfully", "data", orderListDto)
        );
    }
}