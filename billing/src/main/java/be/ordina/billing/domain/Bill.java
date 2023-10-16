package be.ordina.billing.domain;

import jakarta.persistence.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
public class Bill extends AbstractAggregateRoot<Bill> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;

    private Long orderId;
    private Long customerId;

    private boolean paid;
    private LocalDateTime paymentDate;

    public Bill(final BigDecimal amount, final Long orderId, final Long customerId) {
        this.amount = amount;
        this.orderId = orderId;
        this.customerId = customerId;
        this.paid = false;
    }

    public Bill() {
        //
    }

    public void pay() {
        //#lab5
        this.paid = true;
        this.paymentDate = LocalDateTime.now();

        registerEvent(new BillPaidEvent(this));
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public boolean isPaid() {
        return paid;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public class BillPaidEvent {
        private LocalDateTime eventTime;
        private Long billId;
        private Long customerId;
        private Long orderId;
        private BigDecimal amountPaid;

        private LocalDateTime paymentDate;

        public BillPaidEvent(Bill bill) {
            this.billId = bill.getId();
            this.customerId = bill.getCustomerId();
            this.orderId = bill.getOrderId();
            this.amountPaid = bill.getAmount();
            this.paymentDate = bill.getPaymentDate();
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
    }

}
