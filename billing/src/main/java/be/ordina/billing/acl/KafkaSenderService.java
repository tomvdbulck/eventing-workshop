package be.ordina.billing.acl;

import be.ordina.billing.domain.Bill;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
//#lab5 - use a KafkaTemplate
public class KafkaSenderService {


    private final KafkaTemplate<String, Bill.BillPaidEvent> kafkaTemplate;

    public KafkaSenderService(KafkaTemplate<String, Bill.BillPaidEvent> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @TransactionalEventListener
    void onBillPaidEvent(Bill.BillPaidEvent event) {
        kafkaTemplate.send("billing-topic", event);
    }
}
