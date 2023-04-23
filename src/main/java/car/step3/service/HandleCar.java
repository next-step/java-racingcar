package car.step3.service;

import car.step3.domain.Car;
import car.step3.service.MovingStrategy;
import car.step3.service.RandomMovingStrategy;

import java.util.List;

public class HandleCar {
    MovingStrategy movingStrategy = new RandomMovingStrategy();

    public List<Car> iteratorCar(List<Car> cars) {
        for (Car car : cars) {
            goCar(car);
        }
        return cars;
    }

    public void goCar(Car car) {
        car.go(movingStrategy);
    }
}
