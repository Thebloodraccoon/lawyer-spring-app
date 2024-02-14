package org.lawyer.spring.model.mapper;

import org.lawyer.spring.model.dto.ServiceDTO;
import org.lawyer.spring.model.entity.Service;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceMapper {
    Service serviceDTOToService(ServiceDTO serviceDTO);
    ServiceDTO serviceToServiceDTO(Service service);
}
