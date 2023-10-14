package be.ordina.customer.repository;

import be.ordina.customer.domain.CustomerOrder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class OrderRepositoryCustomImpl implements OrderRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CustomerOrder> findByCustomerId(Long customerId) {
        Query orderQuery = em.createQuery("SELECT o from CustomerOrder o WHERE o.customerId = :customerId", CustomerOrder.class);
        orderQuery.setParameter("customerId", customerId);
        return orderQuery.getResultList();
    }
}
