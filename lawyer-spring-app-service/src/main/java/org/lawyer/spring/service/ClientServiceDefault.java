package org.lawyer.spring.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.lawyer.spring.model.dto.ClientDTO;
import org.lawyer.spring.model.dto.ClientListItemDTO;
import org.lawyer.spring.model.entity.Client;
import org.lawyer.spring.model.mapper.ClientMapper;
import org.lawyer.spring.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Scope("prototype")
@RequiredArgsConstructor
public class ClientServiceDefault implements ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepo clientRepo;
    @Override
    public ClientDTO getClientById(Long id) {
        Client byId = clientRepo.findById(id).get();
        return clientMapper.clientToClientDTO(byId);
    }

    @Override
    public List<ClientListItemDTO> getAllClients() {
        List<Client> all = clientRepo.findAll();

        return all.stream()
                .map(clientMapper::clientToClientListItemDTO)
                .toList();
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = clientMapper.clientDTOToClient(clientDTO);
        clientRepo.save(client);

        return clientMapper.clientToClientDTO(client);
    }

    @Override
    @Transactional
    public ClientDTO deleteClient(Long id) {
        Client byId = clientRepo.findById(id).get();
        clientRepo.delete(byId);

        return clientMapper.clientToClientDTO(byId);
    }
}
