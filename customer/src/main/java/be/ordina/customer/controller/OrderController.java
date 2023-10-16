package be.ordina.customer.controller;

import be.ordina.customer.domain.CustomerOrder;
import be.ordina.customer.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/new_order/{id}")
    public String showAddOrderForm(@PathVariable("id") long customerId, Model model) {
        CustomerOrder blankOrder = new CustomerOrder();
        blankOrder.setCustomerId(customerId);
        model.addAttribute("order", blankOrder);
        return "new-order";
    }

    @GetMapping("/list_order/{id}")
    public String listOrdersForCustomer(@PathVariable("id") long customerId, Model model) {

        List<CustomerOrder> orders = orderRepository.findByCustomerId(customerId);

        model.addAttribute("orders", orders);
        model.addAttribute("customerId", customerId);
        return "list-order";
    }


    @PostMapping("/add_order")
    public String addOrder(@Valid CustomerOrder order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-order";
        }

        //make sure we get an order number
        CustomerOrder draftOrder = orderRepository.save(order);

        //#lab1
        //complete the order ... and something else ...
        draftOrder.complete();
        orderRepository.save(draftOrder);

        return "redirect:/list_order/"+order.getCustomerId();
    }
}
