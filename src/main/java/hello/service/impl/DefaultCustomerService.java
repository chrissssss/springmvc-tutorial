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
        customerRepository.save(new Customer(null, "Jack", 25, adressRepository.save(new Address(null, "NANTERRE CT", "77471"))));
        customerRepository.save(new Customer(null, "Mary", 37, adressRepository.save(new Address(null, "W NORMA ST", "77009"))));
        customerRepository.save(new Customer(null, "Peter", 18, adressRepository.save(new Address(null, "S NUGENT AVE", "77571"))));
        customerRepository.save(new Customer(null, "Amos", 23, adressRepository.save(new Address(null, "E NAVAHO TRL", "77449"))));
        customerRepository.save(new Customer(null, "Craig", 45, adressRepository.save(new Address(null, "AVE N", "77587"))));
        customerRepository.save(new Customer(null, "Aries", 19, adressRepository.save(new Address(null, "Broadway/Reade St, New York", "10007"))));
        customerRepository.save(new Customer(null, "Brice", 39, adressRepository.save(new Address(null, "Columbus, OH 43215, USA", "43215"))));
        customerRepository.save(new Customer(null, "Cage", 24, adressRepository.save(new Address(null, "Plano, TX 75074", "75074"))));
        customerRepository.save(new Customer(null, "Ellen", 41, adressRepository.save(new Address(null, "Modesto, CA 95354", "95354"))));
        customerRepository.save(new Customer(null, "Brice", 32, adressRepository.save(new Address(null, "Atlanta, GA 30334", "30334"))));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
