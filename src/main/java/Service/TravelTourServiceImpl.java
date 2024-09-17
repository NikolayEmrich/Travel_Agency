package Service;

import Domain.TravelTour;
import Repository.TourRepository;

import java.util.List;

public class TravelTourServiceImpl implements TravelTourService {

    private TourRepository repository;

    public TravelTourServiceImpl(TourRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(String countryName, String cityName, String tourType, double price) {
        TravelTour tour = new TravelTour(countryName, cityName, tourType, price);
        repository.save(tour);
    }

    @Override
    public List<TravelTour> getAllActiveTravelTours() {
        return repository.findAll()
                .stream().filter(TravelTour::isActual).toList();
    }

    @Override
    public List<TravelTour> getAllTravelTours() {
        return repository.findAll()
                .stream().toList();
    }

    @Override
    public TravelTour getTravelTourById(long id) {
        TravelTour tour = repository.findById(id);

        if (tour != null && tour.isActual()) {
            return tour;
        } else {
            return null;
        }
    }

    @Override
    public TravelTour getTravelTourByCountry(String countryName) {
        List<TravelTour> tours = repository.findAll();

        if (tours.isEmpty()) {
            return null;
        }

        for (TravelTour tour : tours) {
            if (tour.getCountryName().equals(countryName) && tour.isActual()) {
                return tour;
            }
        }
        return null;
    }

    @Override
    public TravelTour getTravelTourByCityName(String cityName) {
        return repository.findAll().stream()
                .filter(x -> x.getCityName().equals(cityName) && x.isActual())
                .findFirst().orElse(null);
    }

    @Override
    public void updateTravelTour(long id, double price) {
        TravelTour tour = repository.findById(id);

        if (tour != null) {
            tour.setPrice(price);
            tour.setActual(true);
        }
        repository.update(tour);   //    --------    NEW ADD     --------
    }

    @Override
    public void deleteTravelTourById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void activatedTravelTourById(long id) {
        TravelTour tour = repository.findById(id);

        if (tour != null && !tour.isActual()) {
            tour.setActual(true);
        }
        repository.update(tour);   //    --------    NEW ADD     --------
    }

    @Override
    public double getSumAllActiveTravelToursPrice() {
        return getAllActiveTravelTours().stream().mapToDouble(TravelTour::getPrice).sum();
    }
}
