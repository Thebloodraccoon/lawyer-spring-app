package org.lawyer.spring.service;

import org.lawyer.spring.model.dto.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.lawyer.spring.model.dto.ClientListItemDTO;
import org.lawyer.spring.model.entity.Client;
import org.lawyer.spring.model.mapper.ClientMapper;
import org.lawyer.spring.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;


@Primary
@Service
@Scope("prototype")
public class ClientServiceDefault implements ClientService {
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ClientRepo clientRepo;
    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepo.find(id);
        return clientMapper.clientToClientDTO(client);
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
    public ClientDTO deleteClient(Long id) {
        Client client = clientRepo.find(id);
        Client remove = clientRepo.remove(client);

        return clientMapper.clientToClientDTO(remove);

    }
}
