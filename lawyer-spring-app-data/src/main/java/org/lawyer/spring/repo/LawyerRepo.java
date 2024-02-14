package org.lawyer.spring.repo;


import org.lawyer.spring.model.entity.Lawyer;

import java.util.List;

public interface LawyerRepo {
    Lawyer save(Lawyer lawyer);
    Lawyer find(Long id);
    List<Lawyer> findAll();
    Lawyer remove(Lawyer lawyer);
}
