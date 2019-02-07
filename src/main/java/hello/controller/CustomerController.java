package hello.controller;

import hello.service.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    final
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String index() {
        return "redirect:/customer";
    }

    @GetMapping("/customer")
    public String getCustomer(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer/customer.table.html";
    }


}