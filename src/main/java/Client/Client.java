package Client;

import Domain.Customer;
import Domain.TravelTour;
import Repository.CustomerRepository;
import Repository.CustomerRepositoryImpl;
import Repository.TourRepository;
import Repository.TourRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        TourRepository repository = new TourRepositoryImpl();
        CustomerRepository repository2 = new CustomerRepositoryImpl();

        /*TravelTour tour1 = new TravelTour(true, "O", "W", "w", 3200, 10);
        TravelTour tour2 = new TravelTour(true, "u", "r", "w", 3455, 11);
        TravelTour tour3 = new TravelTour(true, "y", "e", "s", 3890, 12);
        TravelTour tour4 = new TravelTour(true, "t", "h", "s", 3189, 13);

        repository.save(tour1);
        repository.save(tour2);
        repository.save(tour3);
        repository.save(tour4);

        System.out.println("Список всех туров:");
        List<TravelTour> tours = repository.findAll();
        tours.forEach(System.out::println);*/

        Customer customer1 = new Customer(true, "Jack", new ArrayList<>());
        Customer customer2 = new Customer(true, "Jack", new ArrayList<>());
        Customer customer3 = new Customer(true, "Jack", new ArrayList<>());

        repository2.save(customer1);
        repository2.save(customer2);
        repository2.save(customer3);

        System.out.println("Список всех клиентов:");
        List<Customer> customers = repository2.findAll();
        customers.forEach(System.out::println);





    }
}
