package be.ordina.billing.repository;

import be.ordina.billing.domain.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends CrudRepository<Bill, Long> {
}
