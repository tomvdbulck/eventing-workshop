package be.ordina.customer.repository;

import be.ordina.customer.domain.CustomerOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<CustomerOrder, Long>, OrderRepositoryCustom {

}

