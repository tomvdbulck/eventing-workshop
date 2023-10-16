package be.ordina.customer.acl;

import be.ordina.customer.domain.CustomerOrder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
//#lab3 make use of a KafkaTemplate
public class KafkaSenderService {

    private final KafkaTemplate<String, CustomerOrder.OrderCompletedEvent> kafkaTemplate;

    public KafkaSenderService(KafkaTemplate<String, CustomerOrder.OrderCompletedEvent> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @TransactionalEventListener
    void onCompletedOrder(CustomerOrder.OrderCompletedEvent event) {
        kafkaTemplate.send("order-topic", event);
    }
}
