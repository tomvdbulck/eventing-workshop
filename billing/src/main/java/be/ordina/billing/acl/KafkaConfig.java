package be.ordina.billing.acl;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    //#lab5
    @Bean
    public NewTopic orderTopic() {
        return TopicBuilder.name("billing-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
