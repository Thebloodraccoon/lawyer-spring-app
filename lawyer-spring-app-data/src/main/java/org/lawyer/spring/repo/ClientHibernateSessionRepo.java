package org.lawyer.spring.repo;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.lawyer.spring.model.entity.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class ClientHibernateSessionRepo implements ClientRepo{
    private final SessionFactory sessionFactory;

    @Override
    public Client save(Client client) {
        getCurrentSession().persist(client);
        return client;
    }

    @Override
    public Client find(Long id) {
        return getCurrentSession().find(Client.class, id);
    }

    @Override
    public List<Client> findAll() {
        final Query<Client> query = getCurrentSession().createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }

    @Override
    public Client remove(Client client) {
        getCurrentSession().remove(client);
        return client;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
