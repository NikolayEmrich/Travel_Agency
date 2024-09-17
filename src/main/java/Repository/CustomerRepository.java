package Repository;

import Domain.Customer;
import Domain.TravelTour;

import java.util.List;

public interface CustomerRepository {

    /*Клиент:
    Сохранение клиента
    Получение списка клиентов
    Получение клиента по ID
    Изменение клиента
    Логическое удаление клиента*/

    Customer save(Customer customer);
    List<Customer> findAll();
    Customer findById(long id);
    void update(Customer customer);
    void deleteById(long id);

}
