# eventing-workshop

Consume an event from Kafka.

Now we will be using the Billing application.

## Create a new Intellij project.

Create a new project for the Billing application.

Again disable the JMX metrics from Intellij.


## Excercise

### Setup the properties.

Add the `spring.kafka.consumer.key-deserializer` and `spring.kafka.consumer.value-deserializer`.

Also do not forget to add `spring.kafka.consumer.properties.spring.json.type.mapping=OrderCompletedEvent:be.ordina.billing.acl.OrderConsumer.OrderCompletedEvent`

`spring.kafka.consumer.properties.spring.json.trusted.packages=*` Might be needed to allow deserialization, because the consumer by default does not trust all packages.

### Implement the OrderConsumer

In the `OrderConsumer` implement the `consume` method.

Create a new `Bill` based on data from the event and save this with the `BillingRepository`


## Outcome

You should be able to see a bill being created whenever you create a new order in the other application.
