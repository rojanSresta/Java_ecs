package com.texas.ecommerce.repo;

import com.texas.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    @Query(
            nativeQuery = true,
            value = "select * from orders where user_id = :id"
    )
    public List<Order> fetchOrderByUserId(@Param("id") Integer id);
}
