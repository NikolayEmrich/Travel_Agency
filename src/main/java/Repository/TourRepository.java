package Repository;

import Domain.TravelTour;

import java.util.List;

public interface TourRepository {

    /*Сохранение тура
    Получение списка туров
    Получение конкретного тура по ID
    Изменение тура
    Логическое удаление тура (деактивация)*/

    TravelTour save(TravelTour tour);
    List<TravelTour> findAll();
    TravelTour findById(long id);
    void update(TravelTour tour);
    void deleteById(long id);

}
