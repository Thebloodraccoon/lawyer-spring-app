package org.lawyer.spring.repo;

import org.lawyer.spring.model.entity.Service;

import java.util.List;

public interface ServiceRepo {
    Service save(Service service);
    Service find(Long id);
    List<Service> findAll();
    Service remove(Service service);
}
