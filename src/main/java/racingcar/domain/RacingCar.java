package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RacingCar {

    private final Car[] cars;
    private final int attemptCount;

    public RacingCar(Car[] cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void race(RandomMoveStrategy strategy) {
        for (int i = 0; i < attemptCount; i++) {
            moveCar(strategy);
        }
    }

    private void moveCar(RandomMoveStrategy strategy) {
        for (int j = 0; j < cars.length; j++) {
            if (strategy.movable()) {
                cars[j].moveForward();
            }
        }
    }

    public List<Position> getPositions() {
        return Arrays.stream(cars)
                .map(Car::getPosition)
                .toList();
    }

}
