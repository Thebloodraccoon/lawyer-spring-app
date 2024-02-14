package org.lawyer.spring.repo;

import org.lawyer.spring.model.entity.Client;


import java.util.List;

public interface ClientRepo {
    Client save(Client client);
    Client find(Long id);
    List<Client> findAll();
    Client remove(Client client);
}
