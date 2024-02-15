package org.lawyer.spring.service;

import org.lawyer.spring.model.dto.LawyerDTO;
import org.lawyer.spring.model.dto.LawyerListItemDTO;
import org.lawyer.spring.model.entity.Lawyer;
import org.lawyer.spring.model.mapper.LawyerMapper;
import org.lawyer.spring.repo.LawyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LawyerServiceDefault implements LawyerService {
    @Autowired
    private LawyerRepo lawyerRepo;
    @Autowired
    private LawyerMapper lawyerMapper;

    @Override
    public LawyerDTO getLawyerById(Long id) {
        Lawyer lawyer = lawyerRepo.find(id);

        return lawyerMapper.lawyerToLawyerDTO(lawyer);
    }

    @Override
    public List<LawyerDTO> getAllLawyers() {
        List<Lawyer> all = lawyerRepo.findAll();

        return all.stream()
                .map(lawyerMapper::lawyerToLawyerDTO)
                .toList();
    }

    @Override
    public LawyerDTO createLawyer(LawyerDTO lawyerDTO) {
        Lawyer lawyer = lawyerMapper.lawyerDTOToLawyer(lawyerDTO);

        Lawyer save = lawyerRepo.save(lawyer);
        return lawyerMapper.lawyerToLawyerDTO(save);
    }

    @Override
    public LawyerDTO deleteLawyer(Long id) {
        Lawyer lawyer = lawyerRepo.find(id);

        Lawyer remove = lawyerRepo.remove(lawyer);
        return lawyerMapper.lawyerToLawyerDTO(remove);

    }
}
