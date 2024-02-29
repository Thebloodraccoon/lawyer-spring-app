package org.lawyer.spring.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.lawyer.spring.model.dto.OrderDTO;
import org.lawyer.spring.model.entity.Order;
import org.lawyer.spring.model.mapper.OrderMapper;
import org.lawyer.spring.repo.OrderRepo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
@RequiredArgsConstructor
public class OrderServiceDefault implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepo orderRepo;

    @Override
    public OrderDTO getOrderById(Long id) {
        Order byId = orderRepo.findById(id).get();

        return orderMapper.orderToOrderDTO(byId);
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
    @Transactional
    public OrderDTO deleteOrder(Long id) {
        Order byId = orderRepo.findById(id).get();
        orderRepo.delete(byId);

        return orderMapper.orderToOrderDTO(byId);
    }
}
