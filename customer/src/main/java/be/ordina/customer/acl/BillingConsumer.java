package be.ordina.customer.acl;

import be.ordina.customer.domain.CustomerOrder;
import be.ordina.customer.repository.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
//#lab5
public class BillingConsumer {

    private final Logger logger = LogManager.getLogger(BillingConsumer.class);
    private final OrderRepository orderRepository;

    public BillingConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "billing-topic")
    void onBillPaidEvent(BillPaidEvent event) {
        logger.info("Event received = {}", event);

        CustomerOrder order = this.orderRepository.findById(event.getOrderId()).orElse(null);

        order.setPaid(true);

        this.orderRepository.save(order);

    }

    public static class BillPaidEvent {
        private LocalDateTime eventTime;
        private Long billId;
        private Long customerId;
        private Long orderId;
        private BigDecimal amountPaid;

        private LocalDateTime paymentDate;

        public BillPaidEvent() {
        }

        public Long getBillId() {
            return billId;
        }

        public Long getCustomerId() {
            return customerId;
        }

        public Long getOrderId() {
            return orderId;
        }

        public BigDecimal getAmountPaid() {
            return amountPaid;
        }

        @Override
        public String toString() {
            return "BillPaidEvent{" +
                    "eventTime=" + eventTime +
                    ", billId=" + billId +
                    ", customerId=" + customerId +
                    ", orderId=" + orderId +
                    ", amountPaid=" + amountPaid +
                    ", paymentDate=" + paymentDate +
                    '}';
        }
    }

}
