package Client;

import Controller.CustomerController;
import Controller.TravelTourController;
import Domain.Customer;
import Domain.TravelTour;
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

        // Создание туров:
        /*TravelTour tour1 = new TravelTour(true, "Germany", "Berlin", "H", 3200, 10);
        TravelTour tour2 = new TravelTour(true, "Spain", "Madrid", "L", 3455, 11);
        TravelTour tour3 = new TravelTour(true, "France", "Paris", "H", 3890, 12);
        TravelTour tour4 = new TravelTour(true, "Poland", "Warsaw", "L", 3189, 13);*/

        // Сохранение туров в сервис:
        /*service.save("Germany", "Berlin", "H", 3500);
        service.save("Spain", "Madrid", "L", 3455);
        service.save("France", "Paris", "H", 3890);
        service.save("Poland", "Warsaw", "L", 3189);*/

        // Сохранение туров в репозиторий:
        /*repository.save(tour1);
        repository.save(tour2);
        repository.save(tour3);
        repository.save(tour4);*/

        /*System.out.println("Список всех туров:");
        List<TravelTour> tours = repository.findAll();
        tours.forEach(System.out::println);*/

        // Создание клиентов:
        /*Customer customer1 = new Customer("Jack");
        Customer customer2 = new Customer("John");
        Customer customer3 = new Customer("Jim");*/


        //Сохранение клиентов в репозиторий:
        /*service2.saveCustomer("Jack");
        service2.saveCustomer("John");
        service2.saveCustomer("Jim");*/

        /*System.out.println("Список всех клиентов:");
        List<Customer> customers = repository2.findAll();
        customers.forEach(System.out::println);*/

        // Удаление туров:
        //service.deleteTravelTourById(2);
        //service.deleteTravelTourById(4);

        // Обновление тура:
        //service.updateTravelTour(2, 4500);

        // Активация тура:
        //service.activatedTravelTourById(4);

        /*System.out.println("Список всех туров:");
        service.getAllTravelTours().forEach(System.out::println);
        System.out.printf("Стоимость всех активных туров: " + service.getSumAllActiveTravelToursPrice());

        System.out.println();
        System.out.println("Список всех клиентов:");
        service2.getAllCustomers().forEach(System.out::println);*/

        // Проверка мтодов сервиса:
        /*System.out.println("\n" + service.getTravelTourById(3));
        System.out.println(service.getTravelTourByCountry("Germany"));
        System.out.println(service.getTravelTourByCityName("Berlin"));*/

        // Покупка тура клиентом:
        //service2.addTourToCustomer(1, 2);

        // Создание туров:
        /*controllerTour.save("Germany", "Berlin", "H", 3500);
        controllerTour.save("Spain", "Madrid", "L", 3455);
        controllerTour.save("France", "Paris", "H", 3890);
        controllerTour.save("Poland", "Warsaw", "L", 3189);*/

        // Отображение после покупки:
        //System.out.println("Список всех туров:");
        //controllerTour.getAllTravelTours().forEach(System.out::println);

        // Удаление тура по ID:
        //controllerTour.deleteTravelTourById(3);

        // Стоимость всех активных туров:
        //System.out.printf("Стоимость всех активных туров: " + controllerTour.getSumAllActiveTravelToursPrice());

        // Восстановление утра по ID:
        //controllerTour.activatedTravelTourById(3);

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
        service2.getAllCustomers().forEach(System.out::println);

    }
}