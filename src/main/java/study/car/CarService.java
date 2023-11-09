package study.car;

import java.util.List;

public interface CarService {

    long join(Car car);

    Car findOneCar(Long id);

    List<Car> findAllCars();

    void movingCar(Car car);
}
