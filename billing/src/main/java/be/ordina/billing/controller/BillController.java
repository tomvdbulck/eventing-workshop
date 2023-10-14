package be.ordina.billing.controller;

import be.ordina.billing.domain.Bill;
import be.ordina.billing.repository.BillingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BillController {

    private BillingRepository billingRepository;

    public BillController(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @GetMapping("/")
    public String getBills(Model model) {
        model.addAttribute("bills", billingRepository.findAll());
        return "index";
    }

    @PostMapping("/{id}/pay")
    public String pay(@PathVariable Long id) {
        Bill bill = billingRepository.findById(id).orElse(null);

        bill.pay();

        billingRepository.save(bill);

        return "redirect:/";
    }





}
