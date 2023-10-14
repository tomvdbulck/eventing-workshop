package be.ordina.billing.acl;

import be.ordina.billing.domain.Bill;
import org.springframework.stereotype.Service;

@Service
//#lab5 - use a KafkaTemplate
public class KafkaSenderService {


    void onBillPaidEvent(Bill.BillPaidEvent event) {
        // implement me
    }
}
