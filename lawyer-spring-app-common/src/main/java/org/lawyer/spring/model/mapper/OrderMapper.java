package org.lawyer.spring.model.mapper;

import org.lawyer.spring.model.dto.OrderDTO;
import org.lawyer.spring.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    Order orderDTOToOrder(OrderDTO orderDTO);
    OrderDTO orderToOrderDTO(Order order);
}
