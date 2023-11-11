package study.repository;

import study.domain.Car;

import java.util.List;

public interface CarRepository {

    Car save(Car car);

    Car findCarByName(Car car);

    List<Car> findCarAll();

    void clearStore();

}
