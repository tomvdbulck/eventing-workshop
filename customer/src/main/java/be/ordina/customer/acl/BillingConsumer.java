package be.ordina.customer.acl;

import be.ordina.customer.repository.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    void onBillPaidEvent(BillPaidEvent event) {
        logger.info("Event received = {}", event);

        //implement me

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
