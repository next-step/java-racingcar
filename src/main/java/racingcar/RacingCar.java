package racingcar;

import racingcar.car.Cars;
import racingcar.strategy.MoveStrategy;

public class RacingCar {
    private static final int MINIMUM_ROUND = 1;
    private final int totalRound;
    private final int currentRound;
    private final Cars cars;

    private RacingCar(int numberOfCars, int totalRound, MoveStrategy moveStrategy) {
        validate(totalRound);

        this.totalRound = totalRound;
        this.currentRound = 0;
        this.cars = Cars.of(numberOfCars, moveStrategy);
    }

    private void validate(int totalRound) {
        if (totalRound < MINIMUM_ROUND) {
            throw new IllegalArgumentException("Total round can't be under zero");
        }
    }

    public static RacingCar init(int numberOfCars, int totalRound, MoveStrategy moveStrategy) {
        return new RacingCar(numberOfCars, totalRound, moveStrategy);
    }
}
