package Controller;

import Domain.Customer;
import Service.CustomerService;

import java.util.List;

    /*   Customer Methods:
    public void saveCustomer(String name)
    public void addTourToCustomer(long customerId, long tourId)
    public List<Customer> getAllCustomers()
    public Customer getCustomerById(long id) */

public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    public void save(String name) {
        service.saveCustomer(name);
    }

    public void addTourToCustomer(long customerId, long tourId) {
        service.addTourToCustomer(customerId, tourId);
    }

    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    public Customer getCustomerById(long id) {
        return service.getCustomerById(id);
    }

}
