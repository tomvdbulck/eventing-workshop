# eventing-workshop

## Getting Started
Clone and create a new project in Intellij from the Customer application.
Make sure java 17 is installed.

Disable the JMX agent for Spring Boot, edit - run configuration.

Run the application and make sure you can see the customers.

## Exercise

### Send out a DomainEvent when an order is completed.

In `CustomerOrder` the `complete()` method must be implemented.

From this method you should trigger the `OrderCompletedEvent`.
You should be able to use `registerEvent(x)`

This method will be called when you `addOrder()` in the `OrderController`.

The `draftOrder` is just a little trick to make sure the repository provides us with an id for the order.

### Process the event in the locally

This you would do when working in a modulith or in order to work with events within your service itself.

In the `RandomService` log the event.

You can process this asynchronous, with a `TransactionalEventListener`

### And process the event in the CustomerService

Process the event in the customerService so we can increase the customer his order count.

Very similar ... but you need to think about transactions and what would be the default of the `TransactionalEventListener`

