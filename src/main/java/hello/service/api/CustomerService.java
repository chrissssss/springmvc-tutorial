package hello.service.api;

import hello.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
}
