package org.lawyer.spring.model.mapper;

import org.lawyer.spring.model.dto.ClientDTO;
import org.lawyer.spring.model.dto.ClientListItemDTO;
import org.lawyer.spring.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {
    Client clientDTOToClient(ClientDTO clientDTO);
    ClientDTO clientToClientDTO(Client client);
    ClientListItemDTO clientToClientListItemDTO(Client client);
}
