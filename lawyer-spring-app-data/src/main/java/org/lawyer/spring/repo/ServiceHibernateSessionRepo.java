package org.lawyer.spring.repo;

import org.hibernate.query.Query;
import org.lawyer.spring.model.entity.Service;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class ServiceHibernateSessionRepo implements ServiceRepo {
    private final SessionFactory sessionFactory;

    @Override
    public Service save(Service service) {
        getCurrentSession().persist(service);
        return service;
    }

    @Override
    public Service find(Long id) {
        return getCurrentSession().find(Service.class, id);
    }

    @Override
    public List<Service> findAll() {
        final Query<Service> query = getCurrentSession().createQuery("SELECT s FROM Service s", Service.class);
        return query.getResultList();
    }

    @Override
    public Service remove(Service service) {
        getCurrentSession().remove(service);
        return service;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
