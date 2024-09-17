package Service;

import Domain.Customer;
import Domain.TravelTour;
import Repository.CustomerRepository;
import Repository.TourRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repositoryCustomer;
    private TravelTourService serviceTravelTour;

    public CustomerServiceImpl(CustomerRepository repositoryCustomer, TravelTourService serviceTravelTour) {
        this.repositoryCustomer = repositoryCustomer;
        this.serviceTravelTour = serviceTravelTour;
    }

    @Override
    public void saveCustomer(String name) {
        Customer customer = new Customer(name);
        repositoryCustomer.save(customer);
    }

    @Override
    public void addTourToCustomer(long customerId, long tourId) {  //----- ДОПИСАТЬ УДАЛЕНИЕ ТУРА ИЗ ТУРОВ -------
        Customer customer = repositoryCustomer.findById(customerId);
        if (customer != null) {
            TravelTour tour = serviceTravelTour.getTravelTourById(tourId);
            if (tour != null) {
                customer.getPurchaseHistory().add(tour);
                repositoryCustomer.update(customer);
            }
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repositoryCustomer.findAll();
    }

    @Override
    public Customer getCustomerById(long id) {
        return repositoryCustomer.findById(id);
    }
}
