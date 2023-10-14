# eventing-workshop

When the bill is paid, send out an event.

And have the Customer application process that event and mark the order as paid.


## Excercise

### Implement the Paid domain event.

Update the `pay` method in the `Bill`.

Make sure your domain object is correctly set before registering the `BillPaidEvent`.


### Implement a kafka producer in Billing.

Implement a `KafkaConfig` so the `billing-topic` is automatically created.

Make sure all the producer properties are added to `application.properties`.

Implement the `OnBillPaidEvent` in the `KafkaSenderService` of billing.
So that the event is send to the `billing-topic`.

Again do pay attention for the `spring.kafka.producer.properties.spring.json.type.mapping` in Billing and  `spring.kafka.consumer.properties.spring.json.type.mapping` in Customer.

### Implement a kafka consumer in Customer.

This consumer will listen to the `billing-topic` and take in the event.

And then it should update the `CustomerOrder` so we can also mark that one as paid.


## Outcome

Whenever a bill has been paid, you should see this reflected in the customer application.
