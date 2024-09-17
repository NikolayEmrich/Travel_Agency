package Service;

import Domain.TravelTour;

import java.util.List;

public interface TravelTourService {

//    Сохранить тур
//    Получить список актуальных туров
//    Получить конкретный тур по его ID (активных)
//    Получить конкретный тур по Стране (активных)
//    Получить конкретный тур по Городу(активных)
//    Получить конкретный тур по типу тура (активных) ---------------------
//    Изменить тур (и автоматически его сделать активным)
//    Деактивировать тур по ID
//    Деактивировать тур по Стране   ---------------------
//    Деактивировать тур по Городу   ---------------------
//    Восстановить (активировать) тур по ID
//    Вернуть общую стоимость всех актуальных туров
//    Получить список туров по заданным параметрам (например, по стране) ---------------------

    void save(String countryName, String cityName, String tourType, double price);
    List<TravelTour> getAllActiveTravelTours();
    List<TravelTour> getAllTravelTours();
    TravelTour getTravelTourById(long id);
    TravelTour getTravelTourByCountry(String countryName);
    TravelTour getTravelTourByCityName(String cityName);
    void updateTravelTour(long id, double price);
    void deleteTravelTourById(long id);
    void activatedTravelTourById(long id);
    double getSumAllActiveTravelToursPrice();







}
