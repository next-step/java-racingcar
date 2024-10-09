package racingGame.service;

import racingGame.model.car.Cars;
import racingGame.model.car.Car;
import racingGame.model.strategy.MovementStrategy;

public class RacingGameService {

    private final MovementStrategy movementStrategy;

    public RacingGameService(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public Cars moveAllCarByOneStep(Cars cars) {
        for (Car car : cars.getCars()) {
            moveCarByOneStep(car);
        }
        return cars;
    }

    public void moveCarByOneStep(Car car) {
        if (movementStrategy.isMovable()) {
            car.move();
        }
    }

}
