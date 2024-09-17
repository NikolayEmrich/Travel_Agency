package Controller;

import Domain.TravelTour;
import Service.TravelTourService;
import java.util.List;

/* TravelTour Methods:
    public void save(String countryName, String cityName, String tourType, double price)
    public List<TravelTour> getAllActiveTravelTours()
    public List<TravelTour> getAllTravelTours()
    public TravelTour getTravelTourById(long id)
    public TravelTour getTravelTourByCountry(String countryName)
    public TravelTour getTravelTourByCityName(String cityName)
    public void updateTravelTour(long id, double price)
    public void deleteTravelTourById(long id)
    public void activatedTravelTourById(long id)
    public double getSumAllActiveTravelToursPrice()*/

public class TravelTourController {

    private TravelTourService service;

    public TravelTourController(TravelTourService serviceTour) {
        this.service = serviceTour;
    }

    public void save(String countryName, String cityName, String tourType, double price) {
        service.save(countryName, cityName, tourType, price);
    }

    public List<TravelTour> getAllActiveTravelTours() {
        return service.getAllActiveTravelTours();
    }

    public List<TravelTour> getAllTravelTours() {
        return service.getAllTravelTours();
    }

    public TravelTour getTravelTourById(long id) {
        return service.getTravelTourById(id);
    }

    public TravelTour getTravelTourByCountry(String countryName) {
        return service.getTravelTourByCountry(countryName);
    }

    public TravelTour getTravelTourByCityName(String cityName) {
        return service.getTravelTourByCityName(cityName);
    }

    public void updateTravelTour(long id, double price) {
        service.updateTravelTour(id, price);
    }

    public void deleteTravelTourById(long id) {
        service.deleteTravelTourById(id);
    }

    public void activatedTravelTourById(long id) {
        service.activatedTravelTourById(id);
    }

    public double getSumAllActiveTravelToursPrice() {
        return service.getSumAllActiveTravelToursPrice();
    }

}