package racingcar;

import racingcar.car.Cars;
import racingcar.strategy.MoveStrategy;

public class RacingCar {
    private final Cars cars;

    private RacingCar(int numberOfCars, MoveStrategy moveStrategy) {
        this.cars = Cars.of(numberOfCars, moveStrategy);
    }

    public static RacingCar init(int numberOfCars, MoveStrategy moveStrategy) {
        return new RacingCar(numberOfCars, moveStrategy);
    }
}
