package Repository;

import Domain.Customer;
import Domain.TravelTour;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private File databaseCustomers;
    private ObjectMapper mapper;
    private long currentId;

    public CustomerRepositoryImpl() {
        databaseCustomers = new File("Customers.txt");
        mapper = new ObjectMapper();
        try {
            databaseCustomers.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getMaxId();
    }

    private void getMaxId() {
        List<Customer> customers = findAll();
        if (!customers.isEmpty()) {
            Customer lastCustomer = customers.get(customers.size() - 1);
            currentId = lastCustomer.getId();
        }
    }

    @Override
    public Customer save(Customer customer) {
        List<Customer> customers = findAll();
        customer.setId(++currentId);
        //customer.setActual(true);
        customers.add(customer);

        try {
            mapper.writeValue(databaseCustomers, customers);
            return customer;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> findAll() {
        try {
            Customer[] customers = mapper.readValue(databaseCustomers, Customer[].class);
            List<Customer> result = new ArrayList<>();
            Collections.addAll(result, customers);
            return result;

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Customer findById(long id) {
        return findAll().stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(long id, String name) {
        List<Customer> customers = findAll();

        customers.stream().filter(x -> x.getId() == id).findFirst().ifPresent(x -> x.setName(name));

        try {
            mapper.writeValue(databaseCustomers, customers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(long id) {
        List<Customer> customers = findAll();

        customers.stream().filter(x -> x.getId() == id)
                .limit(1)
                .forEach(x -> x.setActual(false));

        try {
            mapper.writeValue(databaseCustomers, customers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
