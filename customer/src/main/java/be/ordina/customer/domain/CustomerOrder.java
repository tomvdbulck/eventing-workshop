package be.ordina.customer.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
public class CustomerOrder extends AbstractAggregateRoot<CustomerOrder> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;
    @NotBlank(message = " Description is required")
    private String description;

    @NotNull(message = "It must be for a customer")
    private Long customerId;

    @NotNull(message = "It can never be free")
    private BigDecimal amount;

    private boolean paid;

    public Long getOrderNumber() {
        return orderNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void complete(){
        //We do some random shizzle to complete the order.

        //#lab1
    }

    public void pay(){
        this.paid = true;

        //#lab5 what could we do with the OrderPaid Event ... or is that more a lab 6 ;-)
    }

    public class OrderCompletedEvent {

        private LocalDateTime eventTime;

        private Long orderNumber;
        private BigDecimal amount;
        private Long customerId;

        public OrderCompletedEvent(CustomerOrder order) {
            this.eventTime = LocalDateTime.now();
            this.orderNumber = order.getOrderNumber();
            this.amount = order.getAmount();
            this.customerId = order.getCustomerId();
        }

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
    }

    public class OrderPaid {

        private LocalDateTime eventTime;

        private Long orderNumber;
        private BigDecimal amount;
        private Long customerId;

        private boolean paid;

        public OrderPaid(CustomerOrder order) {
            this.eventTime = LocalDateTime.now();
            this.orderNumber = order.getOrderNumber();
            this.amount = order.getAmount();
            this.customerId = order.getCustomerId();
            this.paid = true;
        }

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

        public boolean getPaid() {
            return paid;
        }
    }
}
