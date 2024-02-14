package org.lawyer.spring.service;

import org.lawyer.spring.model.dto.ClientDTO;
import org.lawyer.spring.model.dto.ClientListItemDTO;

import java.util.List;

public interface ClientService {
    ClientDTO getClientById(Long id);
    List<ClientListItemDTO> getAllClients();
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO deleteClient(Long id);
}
