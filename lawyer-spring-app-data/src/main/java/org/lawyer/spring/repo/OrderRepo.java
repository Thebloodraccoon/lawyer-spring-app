package org.lawyer.spring.repo;


import org.lawyer.spring.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepo extends JpaRepository<Order, Long> {
}
