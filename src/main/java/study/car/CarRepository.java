package study.car;

import java.util.List;

public interface CarRepository {

    long save(Car car);

    Car findCarById(Long id);

    List<Car> findCarAll();

    void clearStore();

}
