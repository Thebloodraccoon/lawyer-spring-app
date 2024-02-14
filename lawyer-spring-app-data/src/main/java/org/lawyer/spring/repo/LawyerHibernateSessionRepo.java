package org.lawyer.spring.repo;


import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.lawyer.spring.model.entity.Lawyer;

import java.util.List;


@Repository
@Transactional
@RequiredArgsConstructor
public class LawyerHibernateSessionRepo implements LawyerRepo {
    private final SessionFactory sessionFactory;
    @Override
    public Lawyer save(Lawyer lawyer) {
        getCurrentSession().persist(lawyer);
        return lawyer;
    }

    @Override
    public Lawyer find(Long id) {
        return getCurrentSession().find(Lawyer.class, id);
    }

    @Override
    public List<Lawyer> findAll() {
        final Query<Lawyer> query = getCurrentSession().createQuery("SELECT l FROM Lawyer l", Lawyer.class);
        return query.getResultList();
    }

    @Override
    public Lawyer remove(Lawyer lawyer) {
        getCurrentSession().remove(lawyer);
        return lawyer;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
