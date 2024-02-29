package org.lawyer.spring.repo;


import org.lawyer.spring.model.entity.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LawyerRepo extends JpaRepository<Lawyer, Long> {
}
