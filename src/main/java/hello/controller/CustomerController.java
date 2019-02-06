package hello.controller;

import hello.model.Address;
import hello.model.Customer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController implements InitializingBean {

    private final List<Customer> lstCustomers = new ArrayList<>();

    // CDI way
    // @PostConstruct
    private void init() throws Exception {
        lstCustomers.add(new Customer(1L, "Jack", 25, new Address("NANTERRE CT", "77471")));
        lstCustomers.add(new Customer(2L, "Mary", 37, new Address("W NORMA ST", "77009")));
        lstCustomers.add(new Customer(3L, "Peter", 18, new Address("S NUGENT AVE", "77571")));
        lstCustomers.add(new Customer(4L, "Amos", 23, new Address("E NAVAHO TRL", "77449")));
        lstCustomers.add(new Customer(5L, "Craig", 45, new Address("AVE N", "77587")));
        lstCustomers.add(new Customer(6L, "Aries", 19, new Address("Broadway/Reade St, New York", "10007")));
        lstCustomers.add(new Customer(7L, "Brice", 39, new Address("Columbus, OH 43215, USA", "43215")));
        lstCustomers.add(new Customer(8L, "Cage", 24, new Address("Plano, TX 75074", "75074")));
        lstCustomers.add(new Customer(9L, "Ellen", 41, new Address("Modesto, CA 95354", "95354")));
        lstCustomers.add(new Customer(10L, "Brice", 32, new Address("Atlanta, GA 30334", "30334")));
    }

    // Spring way
    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    @GetMapping
    public String index() {
        return "redirect:/customer";
    }

    @GetMapping("/customer")
    public String getCustomer(Model model) {
        model.addAttribute("customers", lstCustomers);
        return "customer/customer.table.html";
    }


}