package org.lawyer.spring.repo;

import org.lawyer.spring.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepo extends JpaRepository<Client, Long> {
}
