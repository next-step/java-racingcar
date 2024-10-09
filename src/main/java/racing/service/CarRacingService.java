package racing.service;

import racing.entity.Car;
import java.util.List;

public class CarRacingService {

    private final List<Car> cars;

    public CarRacingService(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}

