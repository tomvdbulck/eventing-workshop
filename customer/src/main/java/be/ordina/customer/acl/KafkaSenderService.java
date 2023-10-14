package be.ordina.customer.acl;

import be.ordina.customer.domain.CustomerOrder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
//#lab3 make use of a KafkaTemplate
public class KafkaSenderService {


    public KafkaSenderService(KafkaTemplate<String, CustomerOrder.OrderCompletedEvent> kafkaTemplate){
        //
    }


    void onCompletedOrder(CustomerOrder.OrderCompletedEvent event) {
    }
}
