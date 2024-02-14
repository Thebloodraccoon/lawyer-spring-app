package org.lawyer.spring.model.mapper;

import org.lawyer.spring.model.dto.LawyerDTO;
import org.lawyer.spring.model.dto.LawyerListItemDTO;
import org.lawyer.spring.model.entity.Lawyer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LawyerMapper {
    Lawyer lawyerDTOToLawyer(LawyerDTO lawyerDTO);
    LawyerDTO lawyerToLawyerDTO(Lawyer lawyer);
    LawyerListItemDTO lawyerToLawyerListItemDTO(Lawyer lawyer);
}
