package org.lawyer.spring.service;

import org.lawyer.spring.model.dto.OrderDTO;
import org.lawyer.spring.model.entity.Order;
import org.lawyer.spring.model.mapper.OrderMapper;
import org.lawyer.spring.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class OrderServiceDefault implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepo.find(id);

        return orderMapper.orderToOrderDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> all = orderRepo.findAll();

        return all.stream()
                .map(orderMapper::orderToOrderDTO)
                .toList();
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.orderDTOToOrder(orderDTO);

        Order save = orderRepo.save(order);

        return orderMapper.orderToOrderDTO(save);
    }

    @Override
    public OrderDTO deleteOrder(Long id) {
        Order order = orderRepo.find(id);
        Order remove = orderRepo.remove(order);

        return orderMapper.orderToOrderDTO(remove);
    }
}
