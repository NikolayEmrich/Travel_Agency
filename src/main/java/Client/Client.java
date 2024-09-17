package Client;

import Controller.CustomerController;
import Controller.TravelTourController;
import Repository.CustomerRepository;
import Repository.CustomerRepositoryImpl;
import Repository.TourRepository;
import Repository.TourRepositoryImpl;
import Service.CustomerService;
import Service.CustomerServiceImpl;
import Service.TravelTourService;
import Service.TravelTourServiceImpl;

public class Client {

    public static void main(String[] args) {

        TourRepository repository = new TourRepositoryImpl();
        TravelTourService service = new TravelTourServiceImpl(repository);
        TravelTourController controllerTour = new TravelTourController(service);

        CustomerRepository repository2 = new CustomerRepositoryImpl();
        CustomerService service2 = new CustomerServiceImpl(repository2, service);
        CustomerController controllerCustomer = new CustomerController(service2);

        System.out.println("\nСписок всех туров:");
        controllerTour.getAllTravelTours().forEach(System.out::println);

        // Создание клиентов:
        /*controllerCustomer.save("John");
        controllerCustomer.save("Jack");
        controllerCustomer.save("Jim");*/

        /*System.out.println();
        System.out.println("Список всех клиентов:");
        service2.getAllCustomers().forEach(System.out::println);*/

        //System.out.printf("Стоимость всех активных туров: " + controllerTour.getSumAllActiveTravelToursPrice());

        //System.out.println("\nКлиента ID = 2: " + controllerCustomer.getCustomerById(2));

        // Покупка тура клиентом:
        //controllerCustomer.addTourToCustomer(2,2);

        System.out.println("Список всех клиентов:");
        controllerCustomer.getAllCustomers().forEach(System.out::println);
    }
}