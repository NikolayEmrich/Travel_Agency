package Repository;

import Domain.TravelTour;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TourRepositoryImpl implements TourRepository {

    private File database;
    private ObjectMapper mapper;
    private long currentId;

    public TourRepositoryImpl() {
        database = new File("TravelTour.txt");
        mapper = new ObjectMapper();
        try {
            database.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getMaxId();
    }

    private void getMaxId() {
        List<TravelTour> tours = findAll();
        if (!tours.isEmpty()) {
            TravelTour lastSuperTour = tours.get(tours.size() - 1);
            currentId = lastSuperTour.getId();
        }
    }

    @Override
    public TravelTour save(TravelTour tour) {
        List<TravelTour> tours = findAll();
        tour.setId(++currentId);
        tour.setActual(true);
        tours.add(tour);

        try {
            mapper.writeValue(database, tours);
            return tour;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TravelTour> findAll() {
        try {
            TravelTour[] tours = mapper.readValue(database, TravelTour[].class);
            List<TravelTour> result = new ArrayList<>();
            Collections.addAll(result, tours);
            return result;

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public TravelTour findById(long id) {
        return findAll()
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(TravelTour tour) {
        List<TravelTour> tours = findAll();

        for (TravelTour currentTour : tours) {
            if (currentTour.getId() == tour.getId()) {
                currentTour.setPrice(tour.getPrice());
                currentTour.setActual(true);
                break;
            }
        }
        try {
            mapper.writeValue(database, tours);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(long id) {
        List<TravelTour> tours = findAll();

        tours.stream().filter(x -> x.getId() == id)
                .limit(1)
                .forEach(x -> x.setActual(false));

        try {
            mapper.writeValue(database, tours);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
