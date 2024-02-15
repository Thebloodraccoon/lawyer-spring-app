package org.lawyer.spring.service;

import org.lawyer.spring.model.dto.LawyerDTO;
import org.lawyer.spring.model.dto.LawyerListItemDTO;

import java.util.List;

public interface LawyerService {
    LawyerDTO getLawyerById(Long id);
    List<LawyerDTO> getAllLawyers();
    LawyerDTO createLawyer(LawyerDTO lawyerDTO);
    LawyerDTO deleteLawyer(Long id);
}
