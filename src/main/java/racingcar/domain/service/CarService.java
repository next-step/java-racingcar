package racingcar.domain.service;

import racingcar.domain.Car;
import racingcar.strategy.MovingStrategy;

public class CarService {
    private final MovingStrategy strategy;

    public CarService(MovingStrategy strategy) {
        this.strategy = strategy;
    }

    public Car move(Car car) {
        if (this.strategy.canMove()) {
            return new Car(car.getCarName(), car.getCarPosition().increasePosition());
        }
        return car;
    }
}
