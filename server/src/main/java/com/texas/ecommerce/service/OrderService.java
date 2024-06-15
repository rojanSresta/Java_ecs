package com.texas.ecommerce.service;

import com.texas.ecommerce.dto.OrderDto;

public interface OrderService {
    Integer save(OrderDto orderDto);
}
