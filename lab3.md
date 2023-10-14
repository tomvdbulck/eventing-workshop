# eventing-workshop

Produce an Event to Kafka

The goal of this lab is to send an event to Kafka itself.

Via the kafka consumer shell you should be able to see the events you sent to Kafka.


## Exercise

### Kafka Configuration

Update `application.properties` and add:
`spring.kafka.bootstrap-servers`

In `KafkaConfig` implement `orderTopic` to create the `order-topic` automatically whenever we start up the application.

A `TopicBuilder` should be enough to generate a `NewTopic` via a Spring `Bean`.

When you now startup your application you should be able to see the newly created topic.

```
  > ./kafka-topics --list --bootstrap-server localhost:9092
```

### Send out the message
Update the `application.properties` to define:
`spring.kafka.producer.key-serializer`
and
`spring.kafka.producer.value-serializer`

There is the native `StringSerializer` and also the Spring `JsonSerializer`

Implement the `KafkaSenderService` to listen to the `OrderCompletedEvent`

Send the event to the `order-topic`.

#### Important

Add the following property to `application.properties` to update the headers of the message sent out.

Spring Kafka looks at these to find the correct classes to se- or deserialize.

`spring.kafka.producer.properties.spring.json.type.mapping=OrderCompletedEvent:be.ordina.customer.domain.CustomerOrder$OrderCompletedEvent`


## Outcome
Verify the outcome by running the following command in the shell of your kafka container.

```
  > ./kafka-console-consumer --topic order-topic --from-beginning --bootstrap-server localhost:9092
```



