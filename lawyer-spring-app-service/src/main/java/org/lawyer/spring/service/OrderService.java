package org.lawyer.spring.service;

import org.lawyer.spring.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO getOrderById(Long id);
    List<OrderDTO> getAllOrders();
    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO deleteOrder(Long id);
}
