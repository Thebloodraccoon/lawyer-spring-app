package org.lawyer.spring.controller;

import lombok.RequiredArgsConstructor;
import org.lawyer.spring.model.dto.ClientListItemDTO;
import org.lawyer.spring.service.ClientService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<ClientListItemDTO>> getAllHotels() {
        List<ClientListItemDTO> allClients = clientService.getAllClients();

        return ResponseEntity.ok(allClients);
    }
}
