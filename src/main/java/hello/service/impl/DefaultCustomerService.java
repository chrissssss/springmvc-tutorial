package hello.service.impl;

import hello.dao.AdressRepository;
import hello.dao.CustomerRepository;
import hello.model.Address;
import hello.model.Customer;
import hello.service.api.CustomerService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCustomerService implements CustomerService, InitializingBean {

    private final CustomerRepository customerRepository;

    private final AdressRepository adressRepository;

    @Autowired
    public DefaultCustomerService(AdressRepository adressRepository, CustomerRepository customerRepository) {
        this.adressRepository = adressRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void afterPropertiesSet() {
        customerRepository.save(new Customer(1L, "Jack", 25, adressRepository.save(new Address("NANTERRE CT", "77471"))));
        customerRepository.save(new Customer(2L, "Mary", 37, adressRepository.save(new Address("W NORMA ST", "77009"))));
        customerRepository.save(new Customer(3L, "Peter", 18, adressRepository.save(new Address("S NUGENT AVE", "77571"))));
        customerRepository.save(new Customer(4L, "Amos", 23, adressRepository.save(new Address("E NAVAHO TRL", "77449"))));
        customerRepository.save(new Customer(5L, "Craig", 45, adressRepository.save(new Address("AVE N", "77587"))));
        customerRepository.save(new Customer(6L, "Aries", 19, adressRepository.save(new Address("Broadway/Reade St, New York", "10007"))));
        customerRepository.save(new Customer(7L, "Brice", 39, adressRepository.save(new Address("Columbus, OH 43215, USA", "43215"))));
        customerRepository.save(new Customer(8L, "Cage", 24, adressRepository.save(new Address("Plano, TX 75074", "75074"))));
        customerRepository.save(new Customer(9L, "Ellen", 41, adressRepository.save(new Address("Modesto, CA 95354", "95354"))));
        customerRepository.save(new Customer(10L, "Brice", 32, adressRepository.save(new Address("Atlanta, GA 30334", "30334"))));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
