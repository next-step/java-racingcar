package racingcar.domain.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarsService {
    private final MovingStrategy strategy;

    public CarsService(MovingStrategy strategy) {
        this.strategy = strategy;
    }

    public Cars moveAll(Cars cars) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars.getCars()) {
            CarService carService = new CarService(this.strategy);
            result.add(carService.move(car));
        }
        return new Cars(result);
    }
}
