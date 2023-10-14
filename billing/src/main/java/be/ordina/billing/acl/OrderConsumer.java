package be.ordina.billing.acl;


import be.ordina.billing.domain.Bill;
import be.ordina.billing.repository.BillingRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class OrderConsumer {
    private final Logger logger = LogManager.getLogger(OrderConsumer.class);

    private final BillingRepository billingRepository;

    public OrderConsumer(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }


    //#lab4
    public void consume(OrderCompletedEvent event) {
        logger.info("Order is: {}", event);

        //only logging?

    }

    public static class OrderCompletedEvent {

        public OrderCompletedEvent() {
            //default
        }

        private LocalDateTime eventTime;

        private Long orderNumber;
        private BigDecimal amount;
        private Long customerId;

        public LocalDateTime getEventTime() {
            return eventTime;
        }

        public Long getOrderNumber() {
            return orderNumber;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public Long getCustomerId() {
            return customerId;
        }

        @Override
        public String toString() {
            return "OrderCompletedEvent{" +
                    "eventTime=" + eventTime +
                    ", orderNumber=" + orderNumber +
                    ", amount=" + amount +
                    ", customerId=" + customerId +
                    '}';
        }
    }
}
