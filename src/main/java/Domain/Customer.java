package Domain;

import java.util.List;
import java.util.Objects;

public class Customer {

//    Уникальный идентификатор
//    Логический параметр, указывающий, активен ли клиент
//    Имя клиента
//    История покупок туров
//    Предпочтения по направлениям туров

    private long id;
    private boolean isActual;
    private String name;
    private List<TravelTour> purchaseHistory;

    public Customer() {
    }

    public Customer(boolean isActual, String name, List<TravelTour> purchaseHistory) {
        this.isActual = isActual;
        this.name = name;
        this.purchaseHistory = purchaseHistory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActual() {
        return isActual;
    }

    public void setActual(boolean actual) {
        isActual = actual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TravelTour> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<TravelTour> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && isActual == customer.isActual && Objects.equals(name, customer.name) && Objects.equals(purchaseHistory, customer.purchaseHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActual, name, purchaseHistory);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Customer: id - ");
        builder
                .append(id)
                .append(", name - ")
                .append(name)
                .append(", isActual - ")
                .append(isActual ? "yes" : "no")
                .append("\n")
                .append("Tour List:\n");

        for (TravelTour tour : purchaseHistory) {
            builder.append(tour).append("\n");
        }
        return builder.toString();
    }
}
