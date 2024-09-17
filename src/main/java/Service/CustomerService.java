package Service;

import Domain.Customer;

import java.util.List;

public interface CustomerService {

    /*Сохранить клиента
    Добавить тур в историю покупок клиента
    Удалить тур из истории клиента   -------
    Вернуть список всех клиентов
    Получить информацию о конкретном клиенте по его ID*/

    void saveCustomer(String name);
    void addTourToCustomer(long customerId, long tourId);
    List<Customer> getAllCustomers();
    Customer getCustomerById(long id);

}
