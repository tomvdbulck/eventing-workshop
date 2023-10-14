package be.ordina.customer.service;

import be.ordina.customer.domain.CustomerOrder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class RandomService {

    private Logger logger = LogManager.getLogger(RandomService.class);

    //#lab1 implement this method
    @Async
    @TransactionalEventListener
    void onCompletedOrder(CustomerOrder.OrderCompletedEvent event) {
        logger.info("We had an order on {}, for customer {}, for amount {}", event.getEventTime(), event.getCustomerId(), event.getAmount());
    }
}
