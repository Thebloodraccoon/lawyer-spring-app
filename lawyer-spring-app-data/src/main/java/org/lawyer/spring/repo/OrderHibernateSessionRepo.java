package org.lawyer.spring.repo;

import org.hibernate.query.Query;
import org.lawyer.spring.model.entity.Order;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class OrderHibernateSessionRepo implements OrderRepo {
    private final SessionFactory sessionFactory;

    @Override
    public Order save(Order order) {
        getCurrentSession().persist(order);
        return order;
    }

    @Override
    public Order find(Long id) {
        return getCurrentSession().find(Order.class, id);
    }

    @Override
    public List<Order> findAll() {
        final Query<Order> query = getCurrentSession().createQuery("SELECT o FROM Order o", Order.class);
        return query.getResultList();
    }

    @Override
    public Order remove(Order order) {
        getCurrentSession().remove(order);
        return order;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
