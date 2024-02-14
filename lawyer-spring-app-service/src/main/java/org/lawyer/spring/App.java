package org.lawyer.spring;

import org.lawyer.spring.model.dto.ClientDTO;
import org.lawyer.spring.model.dto.ClientListItemDTO;
import org.lawyer.spring.service.ClientService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext("org.lawyer.spring");

        ClientService clientService = annotationContext.getBean(ClientService.class);

        List<ClientListItemDTO> allClients = clientService.getAllClients();
    }
}