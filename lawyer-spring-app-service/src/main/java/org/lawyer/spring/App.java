package org.lawyer.spring;


import org.lawyer.spring.model.dto.ClientListItemDTO;
import org.lawyer.spring.model.dto.LawyerDTO;
import org.lawyer.spring.model.dto.OrderDTO;
import org.lawyer.spring.service.ClientService;
import org.lawyer.spring.service.LawyerService;
import org.lawyer.spring.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext("org.lawyer.spring");

//        ClientService clientService = annotationContext.getBean(ClientService.class);
//
//        List<ClientListItemDTO> allClients = clientService.getAllClients();
//
//        OrderService orderService = annotationContext.getBean(OrderService.class);
//
//        List<OrderDTO> allOrders = orderService.getAllOrders();

        LawyerService lawyerService = annotationContext.getBean(LawyerService.class);

        LawyerDTO lawyerById = lawyerService.getLawyerById(1L);
    }
}