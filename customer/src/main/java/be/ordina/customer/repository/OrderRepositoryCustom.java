package be.ordina.customer.repository;

import be.ordina.customer.domain.CustomerOrder;

import java.util.List;

public interface OrderRepositoryCustom {


    List<CustomerOrder> findByCustomerId(Long customerId);
}
