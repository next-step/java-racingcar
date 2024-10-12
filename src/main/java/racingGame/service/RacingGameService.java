package racingGame.service;

import racingGame.model.car.CarMovement;
import racingGame.model.car.Cars;
import racingGame.model.car.Car;
import racingGame.model.car.TryNo;
import racingGame.model.strategy.MovementStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {

    private final MovementStrategy movementStrategy;

    public RacingGameService(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public CarMovement moveCarsForAllRounds(Cars cars, int round) {
        TryNo tryNo = new TryNo(round);
        CarMovement ret = new CarMovement();

        tryNo.forEach(() -> {
            Cars car = moveAllCarByOneStep(cars);
            ret.addOneStepProgress(car);
        });

        return ret;
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

    public List<Car> findWinners(Cars cars) {
        int maxPosition = cars.getMaxPosition();
        return cars.findCarsWithSamePosition(maxPosition);
    }

}
