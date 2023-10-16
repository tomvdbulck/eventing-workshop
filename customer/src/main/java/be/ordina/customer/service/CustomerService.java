package be.ordina.customer.service;

import be.ordina.customer.domain.Customer;
import be.ordina.customer.domain.CustomerOrder;
import be.ordina.customer.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setupCustomers(){
        customerRepository.save(new Customer("Ordina"));
        customerRepository.save(new Customer("Jos"));
    }

    //#lab1 Process the OrderCompletedEvent to also update the counter - but transaction lifecycle
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    void onCompletedOrder(CustomerOrder.OrderCompletedEvent event) {
        //update the customer
        Customer customer = customerRepository.findById(event.getCustomerId()).orElse(null);

        customer.setAmountOfOrders(customer.getAmountOfOrders()+1);
        customerRepository.save(customer);
    }
}
