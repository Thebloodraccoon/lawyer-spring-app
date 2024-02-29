package org.lawyer.spring.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.lawyer.spring.model.dto.LawyerDTO;
import org.lawyer.spring.model.entity.Lawyer;
import org.lawyer.spring.model.mapper.LawyerMapper;
import org.lawyer.spring.repo.LawyerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LawyerServiceDefault implements LawyerService {
    private final LawyerRepo lawyerRepo;
    private final LawyerMapper lawyerMapper;

    @Override
    public LawyerDTO getLawyerById(Long id) {
        Lawyer lawyer = lawyerRepo.findById(id).get();

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
    @Transactional
    public LawyerDTO deleteLawyer(Long id) {
        Lawyer biId = lawyerRepo.findById(id).get();

        lawyerRepo.delete(biId);
        return lawyerMapper.lawyerToLawyerDTO(biId);
    }
}
